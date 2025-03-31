package repo

import model.Archive
import model.Note
import java.util.TreeSet

object NoteRepo: AbstractRepo<Note>() {

    override val collection: MutableSet<Note> = TreeSet(compareBy{it})

    override fun thisType(): String {
        return "Заметка"
    }

    fun getByParentId(parentId: Int): List<Note> {
        return collection.filter { note -> note.parentId == parentId }.toList()
    }

    fun save(note: Note, parent: Archive) {

        save(note, parent.id)

    }

    private fun save(entity: Note, parentId: Int) {
        entity.parentId = parentId
        super.save(entity)
    }

}