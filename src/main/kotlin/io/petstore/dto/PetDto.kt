package io.petstore.dto

data class PetDto(
        val id: Long? = null,
        val name: String? = null,
        val category: Category? = null,
        val photoUrls: Array<String>? = null,
        val tags: Array<Tags>? = null,
        val status: String? = null
) {

    data class Category(val id: Long? = null, val name: String? = null) {}

    data class Tags(val id: Long? = null, val name: String? = null) {}

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PetDto) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (category != other.category) return false
        if (photoUrls != null) {
            if (other.photoUrls == null) return false
            if (!photoUrls.contentEquals(other.photoUrls)) return false
        } else if (other.photoUrls != null) return false
        if (tags != null) {
            if (other.tags == null) return false
            if (!tags.contentEquals(other.tags)) return false
        } else if (other.tags != null) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (category?.hashCode() ?: 0)
        result = 31 * result + (photoUrls?.contentHashCode() ?: 0)
        result = 31 * result + (tags?.contentHashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        return result
    }


}