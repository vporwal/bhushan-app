
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Url Search</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
  	
  	<link  href=""""),_display_(Seq[Any](/*10.18*/routes/*10.24*/.Assets.at("app/bower_components/bootstrap/dist/css/bootstrap.min.css"))),format.raw/*10.95*/("""" rel="stylesheet">
  	<link  href=""""),_display_(Seq[Any](/*11.18*/routes/*11.24*/.Assets.at("app/bower_components/angular-bootstrap-datetimepicker/src/css/datetimepicker.css"))),format.raw/*11.118*/("""" rel="stylesheet"/>
	
  </head>
  <body class="menu-right-hidden" style="background: #fffff;" ng-app="youTube" ng-controller="SearchController">
  	<span us-spinner spinner-key="loading..." ></span>
  	<div class="container-fluid">
  		<div id="content" ng-view="/redirectToSearchByUrl">
    	
  		</div>
  	</div>
    
    <script src=""""),_display_(Seq[Any](/*22.19*/routes/*22.25*/.Assets.at("app/bower_components/jquery/dist/jquery.min.js"))),format.raw/*22.85*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*23.19*/routes/*23.25*/.Assets.at("app/bower_components/ng-file-upload/angular-file-upload-shim.min.js"))),format.raw/*23.106*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*24.19*/routes/*24.25*/.Assets.at("app/bower_components/angular/angular.js"))),format.raw/*24.78*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.Assets.at("app/bower_components/angular-resource/angular-resource.js"))),format.raw/*25.96*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*26.19*/routes/*26.25*/.Assets.at("app/bower_components/angular-route/angular-route.js"))),format.raw/*26.90*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.Assets.at("app/bower_components/ngInfiniteScroll/ng-infinite-scroll.js"))),format.raw/*27.98*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*28.19*/routes/*28.25*/.Assets.at("app/bower_components/angular-route/angular-route.js"))),format.raw/*28.90*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*29.19*/routes/*29.25*/.Assets.at("app/bower_components/angular-animate/angular-animate.min.js"))),format.raw/*29.98*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*30.19*/routes/*30.25*/.Assets.at("app/bower_components/angular-bootstrap/ui-bootstrap.js"))),format.raw/*30.93*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*31.16*/routes/*31.22*/.Assets.at("app/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"))),format.raw/*31.95*/(""""></script> 
	<script src=""""),_display_(Seq[Any](/*32.16*/routes/*32.22*/.Assets.at("app/bower_components/ng-file-upload/angular-file-upload.min.js"))),format.raw/*32.98*/(""""></script> 
	<script src=""""),_display_(Seq[Any](/*33.16*/routes/*33.22*/.Assets.at("app/bower_components/angular-xeditable/dist/js/xeditable.js"))),format.raw/*33.95*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*34.19*/routes/*34.25*/.Assets.at("app/bower_components/moment/moment.js"))),format.raw/*34.76*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*35.19*/routes/*35.25*/.Assets.at("app/bower_components/angular-validator/dist/angular-validator.js"))),format.raw/*35.103*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*36.19*/routes/*36.25*/.Assets.at("app/bower_components/angular-validator/dist/angular-validator-rules.js"))),format.raw/*36.109*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*37.19*/routes/*37.25*/.Assets.at("app/bower_components/bootstrap/dist/js/bootstrap.min.js"))),format.raw/*37.94*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*38.19*/routes/*38.25*/.Assets.at("app/bower_components/angular-bootstrap-datetimepicker/src/js/datetimepicker.js"))),format.raw/*38.117*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*39.16*/routes/*39.22*/.Assets.at("app/bower_components/spin.js/spin.js"))),format.raw/*39.72*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*40.16*/routes/*40.22*/.Assets.at("app/bower_components/angular-spinner/angular-spinner.min.js"))),format.raw/*40.95*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*41.16*/routes/*41.22*/.Assets.at("app/bower_components/angular-sanitize/angular-sanitize.min.js"))),format.raw/*41.97*/(""""></script>    
    <script src=""""),_display_(Seq[Any](/*42.19*/routes/*42.25*/.Assets.at("app/scripts/app.js"))),format.raw/*42.57*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*43.19*/routes/*43.25*/.Assets.at("app/scripts/controllers/main.js"))),format.raw/*43.70*/(""""></script>
</body>
</html>

"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Aug 09 18:12:21 IST 2014
                    SOURCE: C:/Users/jagbirs/git/bhushan-app/app/views/main.scala.html
                    HASH: 5998e8da3ec9137dc125872db1605c091eaf3044
                    MATRIX: 786->0|1096->274|1111->280|1204->351|1278->389|1293->395|1410->489|1796->839|1811->845|1893->905|1960->936|1975->942|2079->1023|2146->1054|2161->1060|2236->1113|2303->1144|2318->1150|2411->1221|2478->1252|2493->1258|2580->1323|2647->1354|2662->1360|2757->1433|2824->1464|2839->1470|2926->1535|2993->1566|3008->1572|3103->1645|3170->1676|3185->1682|3275->1750|3339->1778|3354->1784|3449->1857|3514->1886|3529->1892|3627->1968|3692->1997|3707->2003|3802->2076|3869->2107|3884->2113|3957->2164|4024->2195|4039->2201|4140->2279|4207->2310|4222->2316|4329->2400|4396->2431|4411->2437|4502->2506|4569->2537|4584->2543|4699->2635|4763->2663|4778->2669|4850->2719|4914->2747|4929->2753|5024->2826|5088->2854|5103->2860|5200->2935|5271->2970|5286->2976|5340->3008|5407->3039|5422->3045|5489->3090
                    LINES: 29->1|38->10|38->10|38->10|39->11|39->11|39->11|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43
                    -- GENERATED --
                */
            