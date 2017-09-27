package zamgerapi.utility

import zamgerapi.types.RequestHistoryEntry
import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.io.DataOutputStream
import java.nio.charset.StandardCharsets
import java.util.*


class WebUtils {
    companion object {
        val requestHistoy = HashMap<String, RequestHistoryEntry>()
        val CACHE_LIFETIME = 60 * 60 * 1000 // 1 sat

        @Throws(Exception::class)
        fun getHTML(url: String, forceHardReload : Boolean, vararg params : UrlParam, requestMethod : String = "GET"): String {
            var requestData = ""
            var first = true
            for ( param in params ) {
                if ( first ) {
                    first = false
                } else {
                    requestData += "&"
                }
                requestData += param.key + "=" + URLEncoder.encode(param.value, StandardCharsets.UTF_8.toString())
            }

            var urlToRead = url
            //add params to url if GET
            if ( requestMethod.equals("GET", true) && params.isNotEmpty()) {
                urlToRead += "?$requestData"

                //trenutno samo podrzavamo kesiranje GET requests
                if ( requestHistoy.containsKey(url) ) {
                    val cache = requestHistoy.get(url)
                    if ( cache != null && Date().time - cache.date.time > CACHE_LIFETIME ) {
                        return cache.response
                    }
                }
            }

            val result = StringBuilder()
            log(urlToRead)
            val url = URL(urlToRead)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = requestMethod

            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded")
            conn.setRequestProperty( "charset", "utf-8")
            conn.instanceFollowRedirects = true
            conn.useCaches = false

            if ( requestMethod.equals("POST", true)) {
                val urlParameters = requestData
                val postData = urlParameters.toByteArray(StandardCharsets.UTF_8)

                conn.doOutput = true
                conn.setRequestProperty( "Content-Length", Integer.toString( postData.size ))
                DataOutputStream(conn.outputStream).use({ wr -> wr.write(postData) })
            }

            val rd = BufferedReader(InputStreamReader(conn.inputStream))

            var line = rd.readLine()
            while (line != null) {
                result.append(line)

                line = rd.readLine()
            }
            rd.close()

            val response = result.toString()
            requestHistoy.put(urlToRead, RequestHistoryEntry(response))
            return response
        }
    }

    class UrlParam {
        var key : String;
        var value : String;

        constructor(key : String, value : String) {
            this.key = key;
            this.value = value;
        }
    }
}
