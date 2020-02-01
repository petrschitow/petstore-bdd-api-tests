package io.petstore

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
        features = ["src/test/resources/io/petstore"],
        tags = [""],
        plugin = ["pretty", "html:target/cucumber"]
)
class TestRunner {

}