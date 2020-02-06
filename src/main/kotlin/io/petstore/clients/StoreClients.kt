package io.petstore.clients

import com.google.gson.Gson
import io.petstore.dto.StoreDto
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response

fun placeOrderForPet(storeDto: StoreDto?): Response {
    val json = Gson().toJson(storeDto)
    return Given {
        spec(requestSpecification)
        body(json)
    } When {
        post("/store/order")
    } Extract {
        response()
    }
}

fun findOrderById(orderId: Long?): Response {
    return Given {
        spec(requestSpecification)
    } When {
        get("/store/order/$orderId")
    } Extract {
        response()
    }
}
