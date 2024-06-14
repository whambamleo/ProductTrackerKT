package com.whambamleo.utilities

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun makeGETRequest(urlString: String, headers: Map<String, String> = emptyMap()): String {
    val url = URL(urlString)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    for ((key, value) in headers) {
        connection.setRequestProperty(key, value)
    }

    val responseCode = connection.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val inputStream = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuilder()
        var inputLine: String?

        while (inputStream.readLine().also { inputLine = it } != null) {
            response.append(inputLine)
        }
        inputStream.close()

        return response.toString()
    } else {
        throw Exception("GET request failed with response code $responseCode")
    }
}
