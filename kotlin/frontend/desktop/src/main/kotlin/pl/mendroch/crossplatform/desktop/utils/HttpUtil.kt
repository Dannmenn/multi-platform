package pl.mendroch.crossplatform.desktop.utils

import pl.mendroch.crossplatform.utils.HttpApi
import tornadofx.*
import java.io.OutputStream

class HttpUtil : Rest(), HttpApi {
    override suspend fun get(endpoint: String): String {
        return get(endpoint, null).text() ?: throw Error()
    }

    override suspend fun getResource(endpoint: String, output: OutputStream) {
        val response = get(endpoint, null)
        response.content().use {
            it.copyTo(output)
            response.close()
        }
    }
}