package io.petstore.clients

import com.google.gson.Gson
import io.petstore.dto.PetDto
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response

class PetClients : BaseClient() {

    fun addNewPetToTheStore(petDto: PetDto): Response {
        val json = Gson().toJson(petDto)
        return Given {
            spec(requestSpecification)
            body(json)
        } When {
            post("/pet")
        } Then {
            statusCode(200)
        } Extract {
            response()
        }
    }

    fun findPetById(petId: String): Response {
        return Given {
            spec(requestSpecification)
        } When {
            get("/pet/$petId")
        } Then {
            statusCode(200)
        } Extract {
            response()
        }
    }

    fun deletePetFromStoreById(petId: Int): Response {
        return Given {
            spec(requestSpecification)
        } When {
            delete("/pet/$petId")
        } Then {
            statusCode(200)
        } Extract {
            response()
        }
    }
}