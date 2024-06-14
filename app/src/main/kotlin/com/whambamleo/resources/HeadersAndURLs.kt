package com.whambamleo.resources

fun getCoachURL(productId: String): String {
    return "https://www.coachoutlet.com/api/inventory?vgId=$productId&includeVariantData=false&__v__=2-an5x47jiKXbuP_tBs3V"
}

fun getCoachHeaders(productId: String): Map<String, String> {
    return mapOf(
        "authority" to "www.coachoutlet.com",
        "method" to "GET",
        "path" to "/api/inventory?vgId=$productId&includeVariantData=false&__v__=2-an5x47jiKXbuP_tBs3V",
        "scheme" to "https",
        "accept" to "*/*",
        "accept-language" to "en-US,en;q=0.9"
    )
}