package com.whambamleo.models

import aws.sdk.kotlin.services.sns.SnsClient
import aws.sdk.kotlin.services.sns.model.PublishRequest
import com.whambamleo.utilities.ParseStrategy

interface ProductModel {
    val name: String
    val apiUrl: String
    val parseStrategy: ParseStrategy
    val snsTopicARN: String

    fun isAvailable(): Boolean

}