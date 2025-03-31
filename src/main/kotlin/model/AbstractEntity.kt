package model

import java.io.Serializable

abstract class AbstractEntity (val name: String, var parentId: Int): Serializable {
    val id: Int

    companion object {
        var idGenerator: Int = 0
    }

    init {
        id = ++idGenerator
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractEntity) return false

        if (name != other.name) return false
        if (parentId != other.parentId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + parentId
        return result
    }


}