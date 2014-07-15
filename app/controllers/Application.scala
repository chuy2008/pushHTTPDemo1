package controllers

import play.api._
import play.api.mvc._
import play.api.libs.ws.WS
import scala.concurrent.Future
import play.api.libs.json._
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.iteratee._
//import play.libs.WS

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
 
import javax.net.ssl.HttpsURLConnection;

object Application extends Controller 
{

  def index = Action
  {
//        Redirect(new play.api.mvc.Call("POST", "http://127.0.0.1:9000/")).withSession("Code" -> "0001")
    Ok(views.html.index("Your new application is ready."))
  }
  
  
  def proxy = Action  
  {
     val url = "http://10.0.0.2:9000/receiveSimple"
     Async
     {
        WS.url(url).post("content").map(response => 
        {
           val contentType = response.header("Content-Type").getOrElse("text/plain")
           val asStream = response.ahcResponse.getResponseBodyAsStream
           Logger.info(s"Proxying $url")
           Status(response.status).stream(Enumerator.fromStream(asStream)).as(contentType)
        })
     }  
  }
  
/*
 *  this works
 */  
/*
  def proxy = Action  
  {
     val url = "http://10.0.0.2:9000/receiveSimple"
     Async
     {
        WS.url(url).post("content").map(response => 
        {
           val contentType = response.header("Content-Type").getOrElse("text/plain")
           val asStream = response.ahcResponse.getResponseBodyAsStream
           Logger.info(s"Proxying $url")
           Status(response.status).stream(Enumerator.fromStream(asStream)).as(contentType)
        })
     }  
  }
*/ 
/*
 *    end of this works
 */  
  
  def sendStuff = Action
  {

        println("Application Scala routine, line 38, within sendStuff routine")
        var gg = Map("Cel" -> Seq("88"), "Code" -> Seq("99"))      
//        var mm = WS.url("https://android.googleapis.com/gcm/send")
        
        def aa1 =
          WS.url("http://10.0.0.2:9000/receiveSimple").post(gg).map{
          case ii => Ok(ii.body)
           }
        def futureRes = 
        {
            Async{aa1.map(ii => Ok(ii.header.toString))}
        }
        
        futureRes
        
   }
  
  def sendJsonStuff = Action
  {
     val url = "http://10.0.0.2:9000/receiveSimple"
     var gg = Json.toJson(Map("Cel" -> Seq("88"), "Code" -> Seq("99")))  
     Async
     {
        WS.url(url).post(gg).map(response => 
        {
           val contentType = response.header("Content-Type").getOrElse("text/plain")
           val asStream = response.ahcResponse.getResponseBodyAsStream
           Logger.info(s"Proxying $url")
           Status(response.status).stream(Enumerator.fromStream(asStream)).as(contentType)
        })
     }  
  }
  
}
        
/*        
        var mm = WS.url("http://10.0.0.2:9000/receiveSimple") 
        println("Application Scala routine line 42, WS URL = " + mm.url)
        var tt = mm.headers
        var uu = mm.post(gg)    
//        var ll = Json.toJson(Map("Code" -> "88", "DeviceId" -> "99"))    
   
        val qq = uu.map{ii =>ii.body}        
        val rr = Async{qq.map(ii => Ok(ii))}
        rr  
*/
        
/*    
//        WS.url("http://127.0.0.1:9000/posttt").post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))
        var gg = Map("Code" -> Seq("88"), "DeviceId" -> Seq("99"))      
        var mm = WS.url("https://android.googleapis.com/gcm/send")
        var mm = WS.url("http://127.0.0.1:9000/posttt")        
        var tt = mm.headers
        var uu = mm.post(gg)
        var nn = mm.post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))
        var ll = Json.toJson(Map("Code" -> "88", "DeviceId" -> "99"))
//        Ok(ll)
        
        val qq = uu.map{ii =>ii.json}        
        val rr = Async{qq.map(ii => Ok(ii))}
        rr
*/        

  

/*  
  def sendStuff2 = Action
  {  
    Redirect(new play.api.mvc.Call("POST", "http://127.0.0.1:9000"))
//    Redirect(routes.Application.sendStuff)    
  }
 */  


/*
 *   This is working...
 */
/*
 
  def sendStuff = Action
  {
//        WS.url("http://127.0.0.1:9000/posttt").post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))

        var gg = Map("Code" -> Seq("88"), "DeviceId" -> Seq("99"))      
        var mm = WS.url("http://127.0.0.1:9000/posttt")
        var uu = mm.post(gg)
        var nn = mm.post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))
        var ll = Json.toJson(Map("Code" -> "88", "DeviceId" -> "99"))
//        Ok(ll)
        
        val qq = uu.map{ii =>ii.json}        
        val rr = Async{qq.map(ii => Ok(ii))}
        rr
  }

  def sendStuff2 = Action
  {
    Redirect(routes.Application.sendStuff)    
  }

*/
/*
 *     end of working code
 */




/*
 *        the following code works correctly....
 */        
/*
 *        
 * 
        var mm = WS.url("http://127.0.0.1:9000/posttt")               
        var nn = mm.post(Json.toJson(Map("Code" -> "88", "DeviceId" -> "99")))
        var ll = Json.toJson(Map("Code" -> "88", "DeviceId" -> "99"))
        var gg = Map("Code" -> "88", "DeviceId" -> "99")              
        val qq = nn.map{ii => ii.body.toString}
        val rr = Async{qq.map(ii => Ok(ii))}
        rr
*
*            end of working correctly code  
*/      
        
//        val oo = nn.onSuccess{ case ii =>  Ok(ii.json) }
//        Ok(oo.getClass.toString())
        
//        var pp = nn.onComplete(Ok("hullo"))   
/*
        var bb = nn.onSuccess
        {
          case ii => new AsyncResult(ii.body)
        }
 */
//        Ok("hullo")
  
        
//        var oo = nn.map(rr => rr.json)
//        var pp = oo.toString()
//        Ok(pp)
        //      Ok("hullo")
//      WS.url("http://127.0.0.1:9000/posttt").post("content")    
//      Ok(Json.toJson(Map("name" -> "Fregon2", "now" -> "11:00 pm")))
    
      
//  Content-Type:application/json
//  Authorization:key=AIzaSyB-1uEai2WiUapxCs2Q0GZYzPu7Udno5aA
//      WS.url("https://android.googleapis.com/gcm/send").post(Json.toJson(Map("Code" -> "", "DeviceId" -> "")))
//      val holder = WS.url("https://android.googleapis.com/gcm/send")
//      val rr = holder.postAndRetrieveStream("lll")("Content-Type" -> "application/json")
//      val map1 = ("Content-Type" -> "application/json", "Authorization" -> "key=....")
//      val list2 = Map("dd" -> "").toList
//      val complexHolder = holder.withHeaders("Content-Type" -> "application/json", 
//          "Authorization" -> "key=....").post(Json.toJson(Map("Code" -> "dd", "DeviceId" -> "dd")))           
//        val complexHolder = holder.withHeaders("Content-Type" -> "application/json",
//          "Authorization" -> "key=....").post("lll")
    
/*
 *    the code below was compiling OK on July 14th, but throwing a runtime error
 *           play.api.Application$$anon$1: Execution exception[[IllegalArgumentException: null]]
 */    
 /*
        val holder = WS.url("127.0.0.1:9000")        
        val complexHolder = holder.withHeaders("Content-Type" -> "application/json",
          "Authorization" -> "key=....").get

        complexHolder onSuccess
        {
          case msg => msg
        }
        Ok("hullo")
 */
/*
 *   end of block code that was running OK on July 14th....
 */
        
        
/*        
        tt onSuccess 
     {
          case msg => msg
     } 
 */     


/*  
  def sendCode = Action
  {    
    
//private void sendPost() throws Exception {
     def sendPost = 
     {
        var USER_AGENT = "Mozilla/5.0"
//		String url = "https://selfsolve.apple.com/wcResults.do";
        var url = "http://127.0.0.1:9000"
		var obj = new URL(url)
//		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        class httpCon(url: URL) extends HttpURLConnection(url)
        {
/*
 *          have to specify these 3 methods
 */          
          def disconnect = {}
          def usingProxy: Boolean = false
          def connect = {}
          override def getOutputStream = super.getOutputStream
        }
        var con = new httpCon(obj)  // asInstanceOf[HttpsURLConnection]
        con.setDoOutput(true)
        
		//add reuqest header
		con.setRequestMethod("POST")
		con.setRequestProperty("User-Agent", USER_AGENT)
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5")
 
		var urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true)
		var wr = new DataOutputStream(con.getOutputStream())
		wr.writeBytes(urlParameters)
		wr.flush()
		wr.close()
 
		var responseCode = con.getResponseCode()
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		var in = new BufferedReader(new InputStreamReader(con.getInputStream()))
		var inputLine = ""
		var response = new StringBuffer()

/*		
		while ((inputLine = in.readLine()) != null) 
		{
			response.append(inputLine);
		}
		in.close()
 
		//print result
		System.out.println(response.toString) 
 */
	}
		

 
		 System.out.println("\nTesting 2 - Send Http POST request") 
         sendPost
		 Ok("hullo")
  }   
    
   
  def doesNothing = {}
*/
  
  
/*
//      WS.url("https://android.googleapis.com/gcm/send").post(Json.toJson(Map("Code" -> "", "DeviceId" -> "")))
//      val holder = WS.url("https://android.googleapis.com/gcm/send")
        val holder = WS.url("127.0.0.1:9000")
//      val rr = holder.postAndRetrieveStream("lll")("Content-Type" -> "application/json")
//      val map1 = ("Content-Type" -> "application/json", "Authorization" -> "key=....")
//      val list2 = Map("dd" -> "").toList

//      val complexHolder = holder.withHeaders("Content-Type" -> "application/json", 
//          "Authorization" -> "key=....").post(Json.toJson(Map("Code" -> "dd", "DeviceId" -> "dd")))
           
        val complexHolder = holder.withHeaders("Content-Type" -> "application/json",
          "Authorization" -> "key=....").post("lll")
//        val tt = complexHolder.get
          
        complexHolder onSuccess
        {
          case msg => msg
        }
        Ok("hullo")
*/

/*        
        tt onSuccess 
     {
          case msg => msg
     } 
     
  }
*/
         
/*  
  def receiveCode = Action(parse.json)
  {
      request => 
         println("Application scala routine, line 43, request content type = " + request.contentType)
         println("Application scala routine, line 44, request body = " + request.body)
         println("Application scala routine, line 45, request body to String = " + request.toString)
         var codd = ""
         var deviceId = ""
         (request.body \ "Code").asOpt[String].map { code => codd = code}.getOrElse 
         {
             BadRequest("Missing parameter [name]")
          }        
         (request.body \ "deviceID").asOpt[String].map { dId => deviceId = dId}.getOrElse 
         {
             BadRequest("Missing parameter [name]")
          }     
         
         WS.url("https://android.googleapis.com/gcm/send").post(Json.toJson(Map("Code" -> codd, "DeviceId" -> deviceId)))
//         Ok(Json.toJson(Map("Code" -> codd, "DeviceId" -> deviceId)))
         Ok("hullo")
  }
  
   def createJsonMessage(to: String, messageId: String, payload: Map[String, String],
      collapseKey: String, timeToLive: Long, delayWhileIdle: Boolean): String =  
  {
//    var message = new scala.collection.mutable.HashMap[String, Object]
    var message = Map("to" -> Json.toJson(to))
    if (collapseKey != null) 
    {
      message += ("collapse_key" -> Json.toJson(collapseKey))
    }
    if (timeToLive != null) 
    {
      message += ("time_to_live" -> Json.toJson(timeToLive))
    }
    if (delayWhileIdle != null && delayWhileIdle) 
    {
      message += ("delay_while_idle" -> Json.toJson(true))
    }
    message += ("message_id" -> Json.toJson(messageId))
    val payloadd = for (pp <- payload) yield (pp._1, Json.toJson(pp._2))
    val payloaddd = Json.toJson(payloadd)
    message += ("data" -> payloaddd)
    Json.stringify(Json.toJson(message))
  } 
}
 */
