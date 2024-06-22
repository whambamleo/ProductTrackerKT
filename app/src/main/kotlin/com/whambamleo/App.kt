package com.whambamleo

import com.whambamleo.resources.getCoachURL
import com.whambamleo.templates.Product
import com.whambamleo.utilities.getParseStrategy
import com.whambamleo.resources.*
import com.whambamleo.utilities.listTopicsPag

class App {
    // TODO: Make this class Singleton

    fun init() {
        val CM079 = Product(getCoachURL("CM079-SVDTV"), getParseStrategy("COACH"))
        CM079.setHeaders(getCoachHeaders("CM079-SVDTV"))
        println(CM079.getLatestAvailability())

        val CA548 = Product(getCoachURL("CA548-IMRFF"), getParseStrategy("COACH"))
        CA548.setHeaders(getCoachHeaders("CA548-IMRFF"))
        println(CA548.getLatestAvailability())
    }
}

suspend fun main() {
//    App().init()
    listTopicsPag()
}
