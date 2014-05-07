package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import play.Play;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
    static final String Base_URL = Play.application().configuration().getString("Base_URL");
    static final String Base_For_Vid_URL = Play.application().configuration().getString("Base_For_Vid_URL");
    static final String filePath = Play.application().configuration().getString("filePath");
    static final String api_key = Play.application().configuration().getString("api_key");
    public static Result index() {
		return ok(views.html.home.render());
	}

    public static Result redirectToYouTube() {
		return ok(views.html.home.render());
	}
    
    public static Result redirectToSearchByUrl() {
		return ok(views.html.main.render());
	}
    
    @SuppressWarnings("resource")
	public static Result searchData() throws ParseException, ClientProtocolException, IOException, JSONException {
		DynamicForm form = DynamicForm.form().bindFromRequest();
		System.out.println(Base_URL);
		String urlString =Base_URL+"part=snippet&key="+api_key+"&maxResults=20";//
		String searchString = form.get("Search_Keyword");
		if(searchString!= null && !searchString.isEmpty())
		{
			searchString = URLEncoder.encode(searchString,"UTF-8");
			urlString+="&q="+searchString;
		}
		String channel=form.get("Channel_Keyword");
		if(channel != null && !channel.isEmpty())
		{
		    channel = URLEncoder.encode(channel,"UTF-8");
		    urlString+="&channelId="+channel;
		}
		String frmDate =  form.get("from");
		DateFormat format = new SimpleDateFormat("MMM-dd-yyyy");
		DateFormat format2 = new SimpleDateFormat("yyyy-dd-MM'T'HH:mm:ssZ");
		if(frmDate != null && !frmDate.isEmpty())
		{
			Date date = format.parse(frmDate);
			frmDate= format2.format(date);
			frmDate = URLEncoder.encode(frmDate,"UTF-8");
		    urlString+="&publishedAfter="+frmDate;
		}
		
		String toDate = form.get("to"); 
		if(toDate != null && !toDate.isEmpty())
		{
			Date date = format.parse(toDate);
			toDate= format2.format(date);
			toDate = URLEncoder.encode(toDate,"UTF-8");
			urlString+="&publishedBefore="+toDate;
		}
		String searchBy = URLEncoder.encode(form.get("searchBy"),"UTF-8");  
		if(searchBy != null && !searchBy.isEmpty())
		{
			searchBy = URLEncoder.encode(searchBy,"UTF-8");
			 urlString+="&order="+searchBy;
		}
		
		String fileName=searchString;
		String dateName="";
		ICsvBeanWriter beanWriter = null;
		try {
			JSONObject jsonObj = getJsonObjFromUrl(urlString);
 			JSONArray array = jsonObj.getJSONArray("items");
			String videoIds="";
				for(int n = 0; n < array.length(); n++)
				{
				    JSONObject object = array.getJSONObject(n);
				    JSONObject objectI=object.getJSONObject("id");
				   boolean isVid = objectI.isNull("videoId");
				   String vId="";
				   if(!isVid)
				   {
					    vId = objectI.getString("videoId");
					    System.out.println(vId);
					    videoIds += vId+",";
				   }
				   if(n==array.length()-1)
				    {
				    	videoIds=videoIds.substring(0, videoIds.length()-1);
				    }
				}
			//System.out.println("videoIds "+videoIds);
			String urlStrForVid = Base_For_Vid_URL+"id="+videoIds+"&key="+api_key+"&part=snippet,contentDetails,statistics,status";
			JSONObject jsonObj2 = getJsonObjFromUrl(urlStrForVid);
			JSONArray array2 = jsonObj2.getJSONArray("items");
			List<YouTubeResult> results= new ArrayList<>();
			for(int n = 0; n < array2.length(); n++)
			{
				YouTubeResult result = new  YouTubeResult(); 
			    JSONObject object = array2.getJSONObject(n);
			    JSONObject snoppetJson= null;
			    if(object != null)
			    {
				    result.videoId       =object.getString("id");
				    result.urlVideo      ="http://www.youtube.com/watch?v="+ result.videoId;
				    snoppetJson=object.getJSONObject("snippet");
			    }
			    if(snoppetJson != null)
			    {
				    result.publishedDate = snoppetJson.getString("publishedAt");
				    
				    result.title         = snoppetJson.getString("title");
				    result.fullDesc      = snoppetJson.getString("description");
				    result.channelTitle  = snoppetJson.getString("channelTitle");
			    }
			    JSONObject statisticsJson=object.getJSONObject("statistics");
			    if(statisticsJson != null)
			    {
				    result.likes         =statisticsJson.getLong("likeCount");
				    result.disLikes      =statisticsJson.getLong("dislikeCount");
				    result.noOfComments  =statisticsJson.getLong("commentCount");
				    result.viewCount     =statisticsJson.getLong("viewCount");
			    }
			    JSONObject contentDetailsJson=object.getJSONObject("contentDetails");
			    if(contentDetailsJson != null)
			    {
			      result.duration      =contentDetailsJson.getString("duration");
			    }
			    results.add(result);
			}
			CellProcessor[] processors = new CellProcessor[] {
			        new NotNull(), // videoId
			        new NotNull(), // urlVideo
			        new NotNull(), // title
			        new NotNull(), // published date
			        new Optional( new ParseLong()), // likes
			        new Optional( new ParseLong()), // disLikes
			        new Optional( new ParseLong()), // noOfComments
			        new Optional( new ParseLong()), // viewCount
			        new  NotNull(), // duration
			        new NotNull(),// channelTitle
			        new NotNull()//fullDesc
			};
			//String csvFileName = "Java_Books.csv";
			File file = new File(filePath);
			if(!file.exists())
			{
				file.mkdir();
			}
			
			long currentTime = System.currentTimeMillis();
			Date date = new Date(currentTime);
		    DateFormat df = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		    dateName = df.format(date);
		    fileName = fileName+'-'+dateName+".csv";
		    beanWriter = new CsvBeanWriter(new FileWriter(filePath+File.separator+fileName+'-'+dateName+".csv"),
			        CsvPreference.STANDARD_PREFERENCE);
			String[] header = {"videoId", "urlVideo", "title","publishedDate","likes","disLikes","noOfComments","viewCount","duration","channelTitle","fullDesc"};
			beanWriter.writeHeader(header);
			for (YouTubeResult result : results) {
			   beanWriter.write(result, header, processors);
			}
			if(beanWriter != null)
			{
				beanWriter.flush();
			    beanWriter.close();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		response().setContentType("application/octet-stream");
		response().setHeader("Content-Disposition",
		"attachment;filename="+fileName+'-'+dateName+".csv");
		return ok(new File(filePath+File.separator+fileName+'-'+dateName+".csv"));
	}



	private static JSONObject getJsonObjFromUrl(String urlString)
			throws MalformedURLException, URISyntaxException, IOException,
			ClientProtocolException, JSONException {
			URL url = new URL(urlString);
			URI uri = url.toURI();
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(uri);
			HttpResponse response = httpclient.execute(httpGet);
			String jsonString = EntityUtils.toString(response.getEntity()).toString();
			JSONObject jsonObj = new JSONObject(jsonString);
			return jsonObj;
	}

	
}