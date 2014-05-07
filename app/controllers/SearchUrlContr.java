package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;


public class SearchUrlContr extends Controller {
	static final String filePath = Play.application().configuration().getString("filePath");
	public static Result searchByUrl() throws IOException
    {
		DynamicForm form = DynamicForm.form().bindFromRequest();
    	String htmlMainUrl = form.get("Search_Url");
    	String fileName="";
		String dateName="";
    	   Document doc= null;
    				try {
    					//htmlMainUrl=URLEncoder.encode(htmlMainUrl,"UTF-8");
    					doc=Jsoup.connect(htmlMainUrl).get();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					}
    				 catch (IOException e) {
						e.printStackTrace();
					}
    				Elements links= new Elements();
    				links =doc.getElementsByAttribute("href");
    	        	List<UrlResult> urlResults = generateArrayList(links, htmlMainUrl);
    	        	CellProcessor[] processors = new CellProcessor[] {
    				        new NotNull(),// mainUrl
    				        new NotNull()//urls
    				};
    	        	File file = new File(filePath);
    				if(!file.exists())
    				{
    					file.mkdir();
    				}
					long currentTime = System.currentTimeMillis();
					Date date = new Date(currentTime);
				    DateFormat df = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
				    dateName = df.format(date);
					ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter(filePath+File.separator+fileName+'-'+dateName+".csv"),
					        CsvPreference.STANDARD_PREFERENCE);
					String[] header = {"mainUrl","urls"};
					beanWriter.writeHeader(header);
					for(UrlResult result : urlResults) {
					   beanWriter.write(result, header, processors);
					}
					beanWriter.flush();
					beanWriter.close();
					response().setContentType("application/octet-stream");
					response().setHeader("Content-Disposition",
					"attachment;filename="+fileName+'-'+dateName+".csv");		
    		return ok(new File(filePath+File.separator+fileName+'-'+dateName+".csv"));
    }
    public static List<UrlResult> generateArrayList(Elements links,String htmlMainUrl)  {
    	List<UrlResult> urlResults= new ArrayList<>();
    	try {
	    	for (Element link : links) 
	    	{
	    		Elements linksCss= link.getElementsByTag("link");
	    		boolean notCSS = linksCss.isEmpty();
	    		if(notCSS)
	    		{
		    	 	String urls= link.absUrl("href");
			    	UrlResult result = new UrlResult();
			    	if(!urls.isEmpty() || urls != null )
			    	{
			    		result.urls= urls;
			    		result.mainUrl=htmlMainUrl;
			    	}
			    	urlResults.add(result);
	    		}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	    return urlResults;
	}
}
