import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "bhushan"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
        "net.sf.supercsv" % "super-csv-dozer" % "2.1.0",
    "org.json"%"org.json"%"chargebee-1.0",
     "org.jsoup" % "jsoup" % "1.7.3",
    javaCore,
    javaJdbc,
    javaEbean,
     "mysql" % "mysql-connector-java" % "5.1.18"
     
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
 
  )

}
