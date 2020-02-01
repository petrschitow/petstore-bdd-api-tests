package io.swagger.petstore.constants

import io.swagger.petstore.utils.ConfigUtils


object Endpoints {

    val config = ConfigUtils().parseConfig()

    //    val PETSTORE_URL = config.petstoreService.url
    const val PETSTORE_URL = "http://petstore.swagger.io/v2"
}