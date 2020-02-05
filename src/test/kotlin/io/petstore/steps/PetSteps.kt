package io.petstore.steps

import io.cucumber.java8.En
import io.petstore.clients.PetClients
import io.petstore.dto.PetDto
import io.petstore.TestContext
import io.petstore.utils.Utils
import org.assertj.core.api.Assertions.assertThat

class PetSteps constructor(private var testContext: TestContext) : En {

    var categoryId = Utils().getRandom()
    var tagId = Utils().getRandom()
    var photoId = Utils().getRandom()

    init {

        Given("I have randomly generated petId and save it to testContext") {
            testContext.petId = Utils().getRandom()
        }

        Given("I have a json to create a new pet in the store with petId from testContext") {
            testContext.petDto = PetDto(
                    id = testContext.petId,
                    category = PetDto.Category(
                            id = categoryId,
                            name = "Test category name #$categoryId"),
                    name = "Test pet name #${testContext.petId}",
                    photoUrls = arrayOf("https://somecloudbox.com/$photoId.jpg"),
                    status = "Active #${testContext.petId}",
                    tags = arrayOf(PetDto.Tags(
                            id = tagId,
                            name = "Test tag name #$tagId"
                    )))
        }

        When("I send POST-request to endpoint /pet with body from testContext to create a new pet") {
            testContext.response = PetClients().addNewPetToTheStore(testContext.petDto!!)
        }

        When("I find pet by id = {int}") { petId: Long ->
            testContext.response = PetClients().findPetById(petId)
        }

        When("I send GET-request to find pet with petId from testContext") {
            testContext.response = PetClients().findPetById(testContext.petId!!)
        }

        When("I send DELETE-request to delete Pet from store with petId from testContext") {
            testContext.response = PetClients().deletePetFromStoreById(testContext.petId!!)
        }

        Then("I check that the status code is {int}") {statusCode: Int ->
            assertThat(testContext.response!!.statusCode).isEqualTo(statusCode)
        }

        Then("I check that the returned json is equivalent to the json from the testContext") {
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

