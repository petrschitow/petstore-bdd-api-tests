package io.petstore.clients

import com.google.gson.Gson
import io.petstore.dto.StoreDto
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response

class StoreClients : BaseClient() {

    fun placeOrderForPet(storeDto: StoreDto): Response {
        val json = Gson().toJson(storeDto)
        return Given {
            spec(requestSpecification)
            body(json)
        } When {
            post("/store/order")
        } Then {
            statusCode(200)
        } Extract {
            response()
        }
    }

    fun findOrderById(orderId: String): Response {
        return Given {
            spec(requestSpecification)
        } When {
            get("/store/order/$orderId")
        } Then {
            statusCode(200)
        } Extract {
            response()
        }
    }
}