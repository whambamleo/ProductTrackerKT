package com.whambamleo

import com.whambamleo.templates.Product
import com.whambamleo.utilities.getParseStrategy

class App {
    // TODO: Make this class Singleton

    fun init() {

        val abirBirthdayGift = Product("https://www.coachoutlet.com/api/inventory?vgId=CM079-SVDTV&includeVariantData=false&__v__=2-an5x47jiKXbuP_tBs3V" ,
                                        getParseStrategy("COACH"))
        abirBirthdayGift.setHeaders(mapOf(
            "authority" to "www.coachoutlet.com",
            "method" to "GET",
            "path" to "/api/inventory?vgId=CM079-SVDTV&includeVariantData=false&__v__=2-an5x47jiKXbuP_tBs3V",
            "scheme" to "https",
            "accept" to "*/*",
            "accept-language" to "en-US,en;q=0.9"
        ))
        println(abirBirthdayGift.getLatestAvailability())
    }
}

fun main() {
    App().init()
}
