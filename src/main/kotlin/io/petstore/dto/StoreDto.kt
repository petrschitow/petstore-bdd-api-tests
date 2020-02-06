package io.petstore.dto

import java.util.*

data class StoreDto(
        val id: Long? = null,
        val petId: Long? = null,
        val quantity: Int? = null,
        val shipDate: String? = null,
        val status: String? = null,
        val complete: Boolean? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StoreDto) return false

        if (id != other.id) return false
        if (petId != other.petId) return false
        if (quantity != other.quantity) return false
        if (shipDate != other.shipDate) return false
        if (status != other.status) return false
        if (complete != other.complete) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (petId?.hashCode() ?: 0)
        result = 31 * result + (quantity ?: 0)
        result = 31 * result + (shipDate?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (complete?.hashCode() ?: 0)
        return result
    }
}