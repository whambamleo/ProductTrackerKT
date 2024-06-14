package com.whambamleo.models

import com.whambamleo.utilities.ParseStrategy

interface ProductModel {
    val apiUrl: String
    val isAvailable: Boolean
    val parseStrategy: ParseStrategy

    fun getLatestAvailability(): Boolean

    // TODO: keep track of relevant SNS topic
}