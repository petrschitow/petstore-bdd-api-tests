package io.petstore.dto

class ConfigDto {
    data class Config(val petstoreService: PetstoreService)
    data class PetstoreService(val url: String)
}

