// @SOURCE:C:/Users/jagbirs/git/bhushan-app/conf/routes
// @HASH:1f8a0f11c0937cd54abde5f8983048030da0e40d
// @DATE:Sat Aug 09 18:12:20 IST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
package controllers {

// @LINE:12
class ReverseSearchUrlContr {
    

// @LINE:12
def searchByUrl(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchByUrl")
}
                                                
    
}
                          

// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:9
def redirectToSearchByUrl(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "redirectToSearchByUrl")
}
                                                

// @LINE:11
def searchData(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "searchData")
}
                                                

// @LINE:7
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def redirectToYouTube(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "redirectToYouTube")
}
                                                
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.javascript {

// @LINE:12
class ReverseSearchUrlContr {
    

// @LINE:12
def searchByUrl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SearchUrlContr.searchByUrl",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchByUrl"})
      }
   """
)
                        
    
}
              

// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:9
def redirectToSearchByUrl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.redirectToSearchByUrl",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "redirectToSearchByUrl"})
      }
   """
)
                        

// @LINE:11
def searchData : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.searchData",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchData"})
      }
   """
)
                        

// @LINE:7
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:8
def redirectToYouTube : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.redirectToYouTube",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "redirectToYouTube"})
      }
   """
)
                        
    
}
              

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:15
// @LINE:12
// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.ref {

// @LINE:12
class ReverseSearchUrlContr {
    

// @LINE:12
def searchByUrl(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SearchUrlContr.searchByUrl(), HandlerDef(this, "controllers.SearchUrlContr", "searchByUrl", Seq(), "GET", """""", _prefix + """searchByUrl""")
)
                      
    
}
                          

// @LINE:11
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:9
def redirectToSearchByUrl(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.redirectToSearchByUrl(), HandlerDef(this, "controllers.Application", "redirectToSearchByUrl", Seq(), "GET", """""", _prefix + """redirectToSearchByUrl""")
)
                      

// @LINE:11
def searchData(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.searchData(), HandlerDef(this, "controllers.Application", "searchData", Seq(), "GET", """""", _prefix + """searchData""")
)
                      

// @LINE:7
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

// @LINE:8
def redirectToYouTube(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.redirectToYouTube(), HandlerDef(this, "controllers.Application", "redirectToYouTube", Seq(), "GET", """""", _prefix + """redirectToYouTube""")
)
                      
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      