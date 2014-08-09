
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
object home extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>youTube</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
  	
  	<link  href=""""),_display_(Seq[Any](/*10.18*/routes/*10.24*/.Assets.at("app/bower_components/bootstrap/dist/css/bootstrap.min.css"))),format.raw/*10.95*/("""" rel="stylesheet">
  	<link  href=""""),_display_(Seq[Any](/*11.18*/routes/*11.24*/.Assets.at("app/bower_components/angular-bootstrap-datetimepicker/src/css/datetimepicker.css"))),format.raw/*11.118*/("""" rel="stylesheet"/>
	
  </head>
  <body class="menu-right-hidden" style="background: #fffff;" ng-app="youTube" ng-controller="ApplicationController">
  	<div style="width: 100%;float: left;">	
  	</div>
  	<span us-spinner spinner-key="loading..." ></span>
  	<div class="container-fluid">
  		<div id="content" ng-view="">
    		
  		</div>
  	</div>
    
    <script src=""""),_display_(Seq[Any](/*24.19*/routes/*24.25*/.Assets.at("app/bower_components/jquery/dist/jquery.min.js"))),format.raw/*24.85*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.Assets.at("app/bower_components/ng-file-upload/angular-file-upload-shim.min.js"))),format.raw/*25.106*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*26.19*/routes/*26.25*/.Assets.at("app/bower_components/angular/angular.js"))),format.raw/*26.78*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*27.19*/routes/*27.25*/.Assets.at("app/bower_components/angular-resource/angular-resource.js"))),format.raw/*27.96*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*28.19*/routes/*28.25*/.Assets.at("app/bower_components/angular-route/angular-route.js"))),format.raw/*28.90*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*29.19*/routes/*29.25*/.Assets.at("app/bower_components/ngInfiniteScroll/ng-infinite-scroll.js"))),format.raw/*29.98*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*30.19*/routes/*30.25*/.Assets.at("app/bower_components/angular-route/angular-route.js"))),format.raw/*30.90*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*31.19*/routes/*31.25*/.Assets.at("app/bower_components/angular-animate/angular-animate.min.js"))),format.raw/*31.98*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*32.19*/routes/*32.25*/.Assets.at("app/bower_components/angular-bootstrap/ui-bootstrap.js"))),format.raw/*32.93*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*33.16*/routes/*33.22*/.Assets.at("app/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"))),format.raw/*33.95*/(""""></script> 
	<script src=""""),_display_(Seq[Any](/*34.16*/routes/*34.22*/.Assets.at("app/bower_components/ng-file-upload/angular-file-upload.min.js"))),format.raw/*34.98*/(""""></script> 
	<script src=""""),_display_(Seq[Any](/*35.16*/routes/*35.22*/.Assets.at("app/bower_components/angular-xeditable/dist/js/xeditable.js"))),format.raw/*35.95*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*36.19*/routes/*36.25*/.Assets.at("app/bower_components/moment/moment.js"))),format.raw/*36.76*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*37.19*/routes/*37.25*/.Assets.at("app/bower_components/angular-validator/dist/angular-validator.js"))),format.raw/*37.103*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*38.19*/routes/*38.25*/.Assets.at("app/bower_components/angular-validator/dist/angular-validator-rules.js"))),format.raw/*38.109*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*39.19*/routes/*39.25*/.Assets.at("app/bower_components/bootstrap/dist/js/bootstrap.min.js"))),format.raw/*39.94*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*40.19*/routes/*40.25*/.Assets.at("app/bower_components/angular-bootstrap-datetimepicker/src/js/datetimepicker.js"))),format.raw/*40.117*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*41.16*/routes/*41.22*/.Assets.at("app/bower_components/spin.js/spin.js"))),format.raw/*41.72*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*42.16*/routes/*42.22*/.Assets.at("app/bower_components/angular-spinner/angular-spinner.min.js"))),format.raw/*42.95*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*43.16*/routes/*43.22*/.Assets.at("app/bower_components/angular-sanitize/angular-sanitize.min.js"))),format.raw/*43.97*/(""""></script>    
    <script src=""""),_display_(Seq[Any](/*44.19*/routes/*44.25*/.Assets.at("app/scripts/app.js"))),format.raw/*44.57*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*45.19*/routes/*45.25*/.Assets.at("app/scripts/controllers/main.js"))),format.raw/*45.70*/(""""></script>
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
                    DATE: Sat Aug 09 18:12:20 IST 2014
                    SOURCE: C:/Users/jagbirs/git/bhushan-app/app/views/home.scala.html
                    HASH: 9d698c42fa397ea88c943dd828c984955e4f8d6e
                    MATRIX: 786->0|1093->271|1108->277|1201->348|1275->386|1290->392|1407->486|1832->875|1847->881|1929->941|1996->972|2011->978|2115->1059|2182->1090|2197->1096|2272->1149|2339->1180|2354->1186|2447->1257|2514->1288|2529->1294|2616->1359|2683->1390|2698->1396|2793->1469|2860->1500|2875->1506|2962->1571|3029->1602|3044->1608|3139->1681|3206->1712|3221->1718|3311->1786|3375->1814|3390->1820|3485->1893|3550->1922|3565->1928|3663->2004|3728->2033|3743->2039|3838->2112|3905->2143|3920->2149|3993->2200|4060->2231|4075->2237|4176->2315|4243->2346|4258->2352|4365->2436|4432->2467|4447->2473|4538->2542|4605->2573|4620->2579|4735->2671|4799->2699|4814->2705|4886->2755|4950->2783|4965->2789|5060->2862|5124->2890|5139->2896|5236->2971|5307->3006|5322->3012|5376->3044|5443->3075|5458->3081|5525->3126
                    LINES: 29->1|38->10|38->10|38->10|39->11|39->11|39->11|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|64->36|64->36|64->36|65->37|65->37|65->37|66->38|66->38|66->38|67->39|67->39|67->39|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|73->45|73->45|73->45
                    -- GENERATED --
                */
            