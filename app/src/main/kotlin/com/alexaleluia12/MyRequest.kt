package com.alexaleluia12
import java.net.URI
// I get problem import this, IntelliJ does not recognize http package
// File > Project Structure > SDK (choose the same of Kotlin, my case 17)
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class get {
    companion object {
        fun doWork() {
            println("get data from: https://something.com")
            val client = HttpClient.newBuilder().build()
            val request = HttpRequest.newBuilder()
                .uri(URI.create("https://something.com"))
                .build()
            val response = client.send(request, BodyHandlers.ofString())
            println(response.body())
        }
    }
}