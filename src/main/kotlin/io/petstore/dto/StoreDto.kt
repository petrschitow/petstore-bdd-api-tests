package io.petstore.dto

import java.util.*

data class StoreDto(
        val id: Int? = null,
        val petId: Int? = null,
        val quantity: Int? = null,
        val shipDate: Date? = null,
        val status: String? = null,
        val complete: Boolean? = null
) {
}