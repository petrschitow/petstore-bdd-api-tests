package io.petstore.steps

import io.cucumber.core.gherkin.Step
import io.cucumber.java8.En
import io.petstore.clients.PetClients
import io.petstore.dto.PetDto
import io.restassured.response.Response
import io.swagger.petstore.utils.Utils
import org.assertj.core.api.Assertions.assertThat

class PetSteps : En {

    lateinit var petDto: PetDto
    lateinit var response: Response

    init {

        Given("I have json for create a new pet with random data") {
            petDto = PetDto(
                    id = Utils().getRandom(),
                    category = PetDto.Category(
                            id = Utils().getRandom(),
                            name = "Test category name"),
                    name = "Test pet name",
                    photoUrls = arrayOf("https://somecloudbox.com/${Utils().getRandom()}.jpg"),
                    status = "Active",
                    tags = arrayOf(PetDto.Tags(
                            id = Utils().getRandom(),
                            name = "Test tag name"
                    )))
        }

        Given("I have already created Pet in the store with random data"){
            petDto = PetDto(
                    id = Utils().getRandom(),
                    category = PetDto.Category(
                            id = Utils().getRandom(),
                            name = "Test category name"),
                    name = "Test pet name",
                    photoUrls = arrayOf("https://somecloudbox.com/${Utils().getRandom()}.jpg"),
                    status = "Active",
                    tags = arrayOf(PetDto.Tags(
                            id = Utils().getRandom(),
                            name = "Test tag name"
                    )))
           val response =  PetClients().addNewPetToTheStore(petDto)
            assertThat(response.statusCode).isEqualTo(200)
        }

        When("I send request to add new pet to the store$") {
            response = PetClients().addNewPetToTheStore(petDto)
        }

        When("I delete pet with id = {int} from the store"){petId:Int ->
            response = PetClients().deletePetFromStoreById(petId)
        }

        Then("I check that status code is {int}"){ statusCode: Int ->
            assertThat(response.statusCode).isEqualTo(statusCode)
        }


    }
}