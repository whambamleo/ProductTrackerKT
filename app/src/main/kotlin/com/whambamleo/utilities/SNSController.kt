package com.whambamleo.utilities

import aws.sdk.kotlin.services.sns.SnsClient
import aws.sdk.kotlin.services.sns.model.ListTopicsRequest
import aws.sdk.kotlin.services.sns.model.PublishRequest
import aws.sdk.kotlin.services.sns.paginators.listTopicsPaginated
import kotlinx.coroutines.flow.transform

suspend fun listTopicsPag() {
    SnsClient { region = "us-east-1" }.use { snsClient ->
        snsClient
            .listTopicsPaginated(ListTopicsRequest { })
            .transform { it.topics?.forEach { topic -> emit(topic) } }
            .collect { topic ->
                println("The topic ARN is ${topic.topicArn}")
            }
    }
}

suspend fun publishMessage(snsTopicARN: String, message: String, subject: String) {
    val snsClient = SnsClient { region = "us-east-1" }

    val request = PublishRequest {
        this.topicArn = snsTopicARN
        this.message = message
        this.subject = subject
    }

    val response = snsClient.publish(request)
    println("Message sent with ID: ${response.messageId}")
}