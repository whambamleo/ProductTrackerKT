package com.whambamleo

import com.whambamleo.resources.getCoachURL
import com.whambamleo.templates.Product
import com.whambamleo.utilities.getParseStrategy
import com.whambamleo.resources.*
import com.whambamleo.utilities.publishMessage
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

suspend fun main() {
    App().init()
}

class App {
    suspend fun init() {
        // TODO: automate creation of topic
        val CM079 = Product("CM079",
                            getCoachURL("CM079-SVDTV"),
                            getParseStrategy("COACH"),
                "arn:aws:sns:us-east-1:272026318753:CoachCM079")
        CM079.setHeaders(getCoachHeaders("CM079-SVDTV"))

        val products: List<Product> = listOf(CM079)

        while (true) {
            for (product in products) {
                if (product.isAvailable()) {
                    publishMessage(product.snsTopicARN,
                          "${product.name} is available!",
                           "ALERT: Product restocked!")
                }
            }
            runBlocking {
                println("Checks performed. Sleeping for one hour.")
                delay(TimeUnit.HOURS.toMillis(1)) // Delay for 1 hour
            }
        }
    }
}


