package ru.hse.vlad.entities

data class TaskEntity(
    val id : Int,
    val title : String,
    val message : String
) {
    override fun equals(other: Any?): Boolean {
        if (other !is TaskEntity) {
            return false
        }
        return title == other.title &&
                message == other.message && id == other.id
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + message.hashCode()
        return result
    }
}