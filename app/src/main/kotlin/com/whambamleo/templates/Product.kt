package com.whambamleo.templates

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.whambamleo.models.ProductModel
import com.whambamleo.utilities.ParseStrategy
import com.whambamleo.utilities.makeGETRequest

class Product(override val name: String,
              override val apiUrl: String,
              override val parseStrategy: ParseStrategy,
              override val snsTopicARN: String) : ProductModel {
    private var headers: Map<String, String> = mutableMapOf()
    fun setHeaders(inputHeaders: Map<String, String>) {
        headers = inputHeaders
    }

    override fun isAvailable(): Boolean {
        val jsonString = makeGETRequest(apiUrl, headers)
        val gson = Gson()
        val mapType = object : TypeToken<Map<String, Any>>() {}.type
        val jsonMap: Map<String, Any> = gson.fromJson(jsonString, mapType)
        val stockCount = parseStrategy(jsonMap)

        return stockCount > 0
    }


}