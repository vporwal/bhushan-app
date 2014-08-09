// @SOURCE:C:/Users/jagbirs/git/bhushan-app/conf/routes
// @HASH:1f8a0f11c0937cd54abde5f8983048030da0e40d
// @DATE:Sat Aug 09 18:12:20 IST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:7
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Application_redirectToYouTube1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("redirectToYouTube"))))
        

// @LINE:9
private[this] lazy val controllers_Application_redirectToSearchByUrl2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("redirectToSearchByUrl"))))
        

// @LINE:11
private[this] lazy val controllers_Application_searchData3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("searchData"))))
        

// @LINE:12
private[this] lazy val controllers_SearchUrlContr_searchByUrl4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("searchByUrl"))))
        

// @LINE:15
private[this] lazy val controllers_Assets_at5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """redirectToYouTube""","""controllers.Application.redirectToYouTube()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """redirectToSearchByUrl""","""controllers.Application.redirectToSearchByUrl()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """searchData""","""controllers.Application.searchData()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """searchByUrl""","""controllers.SearchUrlContr.searchByUrl()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:7
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Application_redirectToYouTube1(params) => {
   call { 
        invokeHandler(controllers.Application.redirectToYouTube(), HandlerDef(this, "controllers.Application", "redirectToYouTube", Nil,"GET", """""", Routes.prefix + """redirectToYouTube"""))
   }
}
        

// @LINE:9
case controllers_Application_redirectToSearchByUrl2(params) => {
   call { 
        invokeHandler(controllers.Application.redirectToSearchByUrl(), HandlerDef(this, "controllers.Application", "redirectToSearchByUrl", Nil,"GET", """""", Routes.prefix + """redirectToSearchByUrl"""))
   }
}
        

// @LINE:11
case controllers_Application_searchData3(params) => {
   call { 
        invokeHandler(controllers.Application.searchData(), HandlerDef(this, "controllers.Application", "searchData", Nil,"GET", """""", Routes.prefix + """searchData"""))
   }
}
        

// @LINE:12
case controllers_SearchUrlContr_searchByUrl4(params) => {
   call { 
        invokeHandler(controllers.SearchUrlContr.searchByUrl(), HandlerDef(this, "controllers.SearchUrlContr", "searchByUrl", Nil,"GET", """""", Routes.prefix + """searchByUrl"""))
   }
}
        

// @LINE:15
case controllers_Assets_at5(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        