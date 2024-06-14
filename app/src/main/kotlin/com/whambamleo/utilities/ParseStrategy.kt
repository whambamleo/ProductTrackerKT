package com.whambamleo.utilities

typealias ParseStrategy = (Map<String, Any>) -> Double

fun getParseStrategy(type: String): ParseStrategy {
    return when (type) {
        "COACH" -> {
            CoachStrategy
        }
        else -> {
            // TODO: throw exception here
            CoachStrategy
        }
    }
}

val CoachStrategy: ParseStrategy = {
    println("Using Coach strategy")
    ((it["inventory"] as Map<*, *>)["inventoryInfo"] as Map<*, *>) ["stockLevel"] as Double
}

