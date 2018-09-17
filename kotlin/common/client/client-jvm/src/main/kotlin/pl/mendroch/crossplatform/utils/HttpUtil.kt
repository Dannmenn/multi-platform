package pl.mendroch.crossplatform.utils

import pl.mendroch.crossplatform.common.Endpoints.api
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

actual interface HttpApi {
    actual suspend fun get(endpoint: String): String
    actual suspend fun getResource(endpoint: String, output: OutputStream)
}

actual class HttpUtil : HttpApi {
    var baseUrl = url
    override suspend fun get(endpoint: String): String {
        val obj = URL(baseUrl + api + endpoint)

        with(obj.openConnection() as HttpURLConnection) {
            requestMethod = "GET"

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuilder()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                return response.toString()
            }
        }
    }

    override suspend fun getResource(endpoint: String, output: OutputStream) {
        val obj = URL(url + endpoint)

        with(obj.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.use { it.copyTo(output) }
        }
    }

    companion object {
        val HTTP_UTIL = HttpUtil()
    }
}