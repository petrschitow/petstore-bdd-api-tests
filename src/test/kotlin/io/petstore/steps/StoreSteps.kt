package io.petstore.steps

import io.cucumber.java8.En
import io.petstore.TestContext
import io.petstore.clients.findOrderById
import io.petstore.clients.placeOrderForPet
import io.petstore.dto.OrderStatuses
import io.petstore.dto.StoreDto
import io.petstore.utils.getRandom
import org.assertj.core.api.Assertions.assertThat
import java.text.SimpleDateFormat
import java.util.*

class StoreSteps constructor(private var testContext: TestContext) : En {

    init {

        Given("I have a json to placing an order in the store with petId from testContext") {
            val timeNow = Date()
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formattedDate = simpleDateFormat.format(timeNow)
            testContext.storeDto = StoreDto(
                    id = testContext.orderId,
                    petId = testContext.petId,
                    quantity = getRandom().toInt(),
                    shipDate = formattedDate,
                    status = OrderStatuses.PLACED.status,
                    complete = true
            )
        }

        When("I send a json to place a order to endpoint \\/store\\/order with body from testContext") {
            testContext.response = placeOrderForPet(testContext.storeDto)
        }

        When("I send GET-request to find placed order with petId from testContext") {
            testContext.response = findOrderById(testContext.orderId)
        }

        And("I check response with information about placed order") {
            val response = testContext.response!!.`as`(StoreDto::class.java)

            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formattedDate = simpleDateFormat.parse(response.shipDate)
            val formattedDate2 = simpleDateFormat.parse(testContext.storeDto!!.shipDate)

            assertThat(response.id).isEqualTo(testContext.orderId)
            assertThat(response.petId).isEqualTo(testContext.storeDto!!.petId)
            assertThat(response.quantity).isEqualTo(testContext.storeDto!!.quantity)
            assertThat(formattedDate).isEqualTo(formattedDate2)
            assertThat(response.status).isEqualTo(testContext.storeDto!!.status)
            assertThat(response.complete).isEqualTo(testContext.storeDto!!.complete)
        }
    }
}