package code 
package snippet 

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import scala.tools.nsc._
class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date]

  val settings = new Settings()
   settings.processArgumentString("-usejavacp")

   class myimain extends tools.nsc.interpreter.IMain(settings)
   {
     def lastRequest = prevRequestList.last
   }
   val n = new myimain()
   n.interpret("var d = List(1,2,3)")
   val b = n.lastRequest.lineRep.call("$result")
  def howdy = "#time *" #> b.toString

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

