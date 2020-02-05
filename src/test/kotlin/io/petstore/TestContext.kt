package io.petstore

import io.petstore.dto.PetDto
import io.petstore.dto.StoreDto
import io.restassured.response.Response

class TestContext {
    var response: Response? = null
    var storeDto: StoreDto? = null
    var petDto: PetDto? = null
    var petId: Long? = null

}