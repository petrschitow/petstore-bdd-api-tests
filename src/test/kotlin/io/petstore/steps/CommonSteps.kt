package io.petstore.steps

import io.cucumber.java8.En
import io.petstore.TestContext
import io.petstore.utils.getRandom
import org.assertj.core.api.Assertions

class CommonSteps constructor(private var testContext: TestContext) : En {
    init {

        Given("I have randomly generated {string} and save it to testContext") { idType: String ->
            if (idType == "petId") {
                testContext.petId = getRandom()
            } else if (idType == "orderId") {
                testContext.orderId = getRandom()
            }
        }

        Then("I check that the status code is {int}") { statusCode: Int ->
            Assertions.assertThat(testContext.response!!.statusCode).isEqualTo(statusCode)
        }

    }
}