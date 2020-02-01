package io.swagger.petstore.utils

import com.sksamuel.hoplite.ConfigLoader
import io.petstore.dto.ConfigDto

class ConfigUtils {

    val env = if (System.getenv("env").isNullOrEmpty()) "test" else System.getenv("env")

    fun parseConfig(): ConfigDto.Config {
        var configFile = ""
        when (env) {
            "test" -> configFile = "/config-test.yaml"
            "prod" -> configFile = "/config-prod.yaml"
        }

        return ConfigLoader().loadConfigOrThrow(configFile)
    }

}