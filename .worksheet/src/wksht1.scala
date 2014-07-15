import play.api._
import play.api.mvc._
import play.api.libs.ws.WS
import scala.concurrent.Future
import play.api.libs.json._
import play.api.libs.concurrent.Execution.Implicits._
//import play.libs.WS

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
 
import javax.net.ssl.HttpsURLConnection;

object wksht1
{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(455); 
  println("Welcome to the Scala worksheet");$skip(177); 

//        WS.url("http://127.0.0.1:9000/posttt").post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))

        var gg = Map("Code" -> Seq("88"), "DeviceId" -> Seq("99"));System.out.println("""gg  : scala.collection.immutable.Map[String,Seq[String]] = """ + $show(gg ));$skip(11); val res$0 = 
        gg;System.out.println("""res0: scala.collection.immutable.Map[String,Seq[String]] = """ + $show(res$0));$skip(136); 
          
//        var mm = WS.url("https://android.googleapis.com/gcm/send")
        var mm = WS.url("http://127.0.0.1:9000/posttt");System.out.println("""mm  : play.api.libs.ws.WS.WSRequestHolder = """ + $show(mm ));$skip(28); 
        var tt = mm.headers;System.out.println("""tt  : Map[String,Seq[String]] = """ + $show(tt ));$skip(11); val res$1 = 
        tt;System.out.println("""res1: Map[String,Seq[String]] = """ + $show(res$1));$skip(29); 
        var uu = mm.post(gg);System.out.println("""uu  : scala.concurrent.Future[play.api.libs.ws.Response] = """ + $show(uu ));$skip(79); 
        var nn = mm.post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")));System.out.println("""nn  : scala.concurrent.Future[play.api.libs.ws.Response] = """ + $show(nn ));$skip(70); 
        var ll = Json.toJson(Map("Code" -> "88", "DeviceId" -> "99"));System.out.println("""ll  : play.api.libs.json.JsValue = """ + $show(ll ));$skip(64); 
//        Ok(ll)
        
        val qq = uu.map{ii =>ii.json};System.out.println("""qq  : scala.concurrent.Future[play.api.libs.json.JsValue] = """ + $show(qq ))}
//        val rr = Async{qq.map(ii => Ok(ii))}
//        rr
}
