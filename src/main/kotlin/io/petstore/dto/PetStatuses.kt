package io.petstore.dto

enum class PetStatuses(val status: String) {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold")
}