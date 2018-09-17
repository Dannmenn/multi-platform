package pl.mendroch.crossplatform.utils

import kotlinx.io.OutputStream
import org.w3c.xhr.XMLHttpRequest
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.suspendCoroutine

actual interface HttpApi {
    actual suspend fun get(endpoint: String): String
    actual suspend fun getResource(endpoint: String, output: OutputStream)
}

actual class HttpUtil : HttpApi {
    var baseUrl = url
    override suspend fun get(endpoint: String): String = suspendCoroutine { c ->
        val xhr = XMLHttpRequest()
        xhr.onreadystatechange = {
            if (xhr.readyState == XMLHttpRequest.DONE) onDone(xhr, c)
            null
        }
        xhr.open("GET", baseUrl + endpoint)
        xhr.send()
    }

    private fun onDone(xhr: XMLHttpRequest, c: Continuation<String>) {
        if (xhr.status in 200..299) {
            val response = xhr.response as String
            c.resume(response)
        } else {
            c.resumeWithException(Error("HTTP error: ${xhr.status} ${xhr.responseText}"))
        }
    }

    override suspend fun getResource(endpoint: String, output: OutputStream) {
        throw UnsupportedOperationException()
    }

    companion object {
        val HTTP_UTIL = HttpUtil()
    }
}