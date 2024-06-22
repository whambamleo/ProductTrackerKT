package com.whambamleo.models

import aws.sdk.kotlin.services.sns.SnsClient
import aws.sdk.kotlin.services.sns.model.PublishRequest
import com.whambamleo.utilities.ParseStrategy

interface ProductModel {
    val apiUrl: String
    val isAvailable: Boolean
    val parseStrategy: ParseStrategy
    val snsTopicARN: String

    fun getLatestAvailability(): Boolean

}