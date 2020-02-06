package io.petstore.steps

import io.cucumber.java8.En
import io.petstore.dto.PetDto
import io.petstore.TestContext
import io.petstore.clients.addNewPetToTheStore
import io.petstore.clients.deletePetFromStoreById
import io.petstore.clients.findPetById
import io.petstore.dto.PetStatuses
import io.petstore.utils.getRandom
import org.assertj.core.api.Assertions.assertThat

class PetSteps constructor(private var testContext: TestContext) : En {

    var categoryId = getRandom()
    var tagId = getRandom()
    var photoId = getRandom()

    init {

        Given("I have a json to create a new pet in the store with petId from testContext") {
            testContext.petDto = PetDto(
                    id = testContext.petId,
                    category = PetDto.Category(
                            id = categoryId,
                            name = "Test category name #$categoryId"),
                    name = "Test pet name #${testContext.petId}",
                    photoUrls = arrayOf("https://somecloudbox.com/$photoId.jpg"),
                    status = PetStatuses.AVAILABLE.status,
                    tags = arrayOf(PetDto.Tags(
                            id = tagId,
                            name = "Test tag name #$tagId"
                    )))
        }

        When("I send POST-request to endpoint /pet with body from testContext to create a new pet") {
            testContext.response = addNewPetToTheStore(testContext.petDto!!)
        }

        When("I find pet by id = {int}") { petId: Long ->
            testContext.response = findPetById(petId)
        }

        When("I send GET-request to find pet with petId from testContext") {
            testContext.response = findPetById(testContext.petId!!)
        }

        When("I send DELETE-request to delete Pet from store with petId from testContext") {
            testContext.response = deletePetFromStoreById(testContext.petId!!)
        }

        Then("I check response with information about pet") {
            val response = testContext.response!!.`as`(PetDto::class.java)

            assertThat(response.id).isEqualTo(testContext.petDto!!.id)
            assertThat(response.category!!.id).isEqualTo(testContext.petDto!!.category!!.id)
            assertThat(response.category!!.name).isEqualTo(testContext.petDto!!.category!!.name)
            assertThat(response.name).isEqualTo(testContext.petDto!!.name)
            assertThat(response.photoUrls).isEqualTo(testContext.petDto!!.photoUrls)
            assertThat(response.status).isEqualTo(testContext.petDto!!.status)
            assertThat(response.tags!![0].id).isEqualTo(testContext.petDto!!.tags!![0].id)
            assertThat(response.tags!![0].name).isEqualTo(testContext.petDto!!.tags!![0].name)
        }
    }
}

