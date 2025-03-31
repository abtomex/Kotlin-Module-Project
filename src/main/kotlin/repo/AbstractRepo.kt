package repo

import model.AbstractEntity

abstract class AbstractRepo<T: AbstractEntity>{

    abstract val collection: MutableSet<T>

    fun save(entity: T) {
        if (collection.contains(entity)) {
            println(String.format("%s с именем %s уже существует\n", thisType(), entity.name))
            return
        }
        collection.add(entity)

    }

    fun getAll(): Set<T> {
        return collection
    }

    fun getByName(name: String) : List<T>{
        return collection.filter { entity -> entity.name == name }.toList()
    }

    open fun getById(id: Int): T {
        return collection.first { entity -> entity.id == id }
    }

    fun getByParentIdAndName(input: String, parentId: Int): T? {

        val found = collection.filter { it.name == input }.filter { it.parentId == parentId }
        if(found.isEmpty()) return null
        return found.first()

    }

    abstract fun thisType(): String

}