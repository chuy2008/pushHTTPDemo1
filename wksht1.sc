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
{
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

//        WS.url("http://127.0.0.1:9000/posttt").post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))

        var gg = Map("Code" -> Seq("88"), "DeviceId" -> Seq("99"))
                                                  //> gg  : scala.collection.immutable.Map[String,Seq[String]] = Map(Code -> List(
                                                  //| 88), DeviceId -> List(99))
        gg                                        //> res0: scala.collection.immutable.Map[String,Seq[String]] = Map(Code -> List(
                                                  //| 88), DeviceId -> List(99))
          
//        var mm = WS.url("https://android.googleapis.com/gcm/send")
        var mm = WS.url("http://127.0.0.1:9000/posttt")
                                                  //> mm  : play.api.libs.ws.WS.WSRequestHolder = WSRequestHolder(http://127.0.0.1
                                                  //| :9000/posttt,Map(),Map(),None,None,None,None,None)
        var tt = mm.headers                       //> tt  : Map[String,Seq[String]] = Map()
        tt                                        //> res1: Map[String,Seq[String]] = Map()
        var uu = mm.post(gg)                      //> uu  : scala.concurrent.Future[play.api.libs.ws.Response] = scala.concurrent.
                                                  //| impl.Promise$DefaultPromise@5484aea0
        var nn = mm.post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))
                                                  //> nn  : scala.concurrent.Future[play.api.libs.ws.Response] = scala.concurrent.
                                                  //| impl.Promise$DefaultPromise@1e7a9a19
        var ll = Json.toJson(Map("Code" -> "88", "DeviceId" -> "99"))
                                                  //> ll  : play.api.libs.json.JsValue = {"Code":"88","DeviceId":"99"}
//        Ok(ll)
        
        val qq = uu.map{ii =>ii.json}             //> qq  : scala.concurrent.Future[play.api.libs.json.JsValue] = scala.concurren
                                                  //| t.impl.Promise$DefaultPromise@326cd1bd-
//        val rr = Async{qq.map(ii => Ok(ii))}
//        rr
}