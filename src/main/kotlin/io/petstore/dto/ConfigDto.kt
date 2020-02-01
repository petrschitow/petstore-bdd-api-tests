package io.petstore.dto

class ConfigDto {
    data class Config(val petstoreService: PetstoreService, val threads: Int)
    data class PetstoreService(val url: String)
}

