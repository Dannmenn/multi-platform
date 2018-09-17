package pl.mendroch.crossplatform.utils

import kotlinx.io.OutputStream

expect interface HttpApi {
    suspend fun get(endpoint: String): String
    suspend fun getResource(endpoint: String, output: OutputStream)
}

expect class HttpUtil : HttpApi

const val url = "http://localhost:8080"