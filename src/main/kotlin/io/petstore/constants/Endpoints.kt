package io.swagger.petstore.constants

import io.petstore.utils.parseConfig


object Endpoints {

    val config = parseConfig()

        val PETSTORE_URL = config.petstoreService.url
//    const val PETSTORE_URL = "http://petstore.swagger.io/v2"
}