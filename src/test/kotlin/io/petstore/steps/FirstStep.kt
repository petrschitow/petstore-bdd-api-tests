package io.petstore.steps

import io.cucumber.java8.En
import io.cucumber.java8.PendingException

class FirstStep: En {
    init{
        Given("^I have some test data$"){

            throw PendingException()
        }

        When("^I send request$"){

            throw PendingException()
        }

        Then("^I check result$"){

            throw PendingException()
        }
    }
}