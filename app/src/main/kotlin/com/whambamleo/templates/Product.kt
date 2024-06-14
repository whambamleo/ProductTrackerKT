package com.whambamleo.templates

import com.whambamleo.models.ProductModel
import com.whambamleo.utilities.makeGETRequest

class Product(override val apiUrl: String) : ProductModel {
    private var headers: Map<String, String> = mutableMapOf()
    fun setHeaders(inputHeaders: Map<String, String>) {
        headers = inputHeaders
    }

    override var isAvailable: Boolean = false

    override fun getLatestAvailability(): Boolean {
//        TODO("Not yet implemented")
        getResponseFromAPI()
        return false
    }

    private fun getResponseFromAPI() {
        println(makeGETRequest(apiUrl, headers))
    }
}