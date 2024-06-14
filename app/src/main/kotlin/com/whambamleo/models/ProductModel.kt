package com.whambamleo.models

interface ProductModel {
    val apiUrl: String

    val isAvailable: Boolean

    fun getLatestAvailability(): Boolean

    // TODO: keep track of relevant SNS topic
}