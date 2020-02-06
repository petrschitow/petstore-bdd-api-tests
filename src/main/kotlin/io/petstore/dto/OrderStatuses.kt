package io.petstore.dto

enum class OrderStatuses(val status: String) {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered")
}