package com.whambamleo.tests.utilities

//import com.whambamleo.utilities.makeGETRequest
//import org.junit.jupiter.api.Assertions.assertTrue
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.assertDoesNotThrow
//
//class HTTPUtilsTests {
//
//    // TODO: Mock Connection class and test GET request
//
//    @Test
//    fun `test simple connection with no headers`() {
//        assertDoesNotThrow {
//            makeGETRequest("https://www.google.com")
//        }
//    }
//
//    @Test
//    fun `test simple connection with headers`() {
//        val headers: Map<String, String> = mapOf(
//            "accept" to "*/*",
//            "accept-language" to "en-US,en;q=0.9"
//        )
//        assertDoesNotThrow {
//            makeGETRequest("https://www.google.com", headers)
//        }
//    }
//}