package repo

import model.Archive
import java.util.TreeSet

object ArchiveRepo : AbstractRepo<Archive>() {

    override val collection: MutableSet<Archive> = TreeSet(compareBy { it.name.lowercase() })
    override fun thisType(): String {
        return "Архив"
    }

    fun getOneByName(name: String): Archive? {
        val foundByName = getByName(name)
        if (foundByName.isEmpty()) return null

        return fillNotes(foundByName.first())
    }

    override fun getById(id: Int): Archive {
        val toReturn = super.getById(id)
        return fillNotes(toReturn)
    }

    private fun fillNotes( toReturn: Archive): Archive {
        NoteRepo.getByParentId(toReturn.id).forEach { note -> toReturn.notes[note.name] = note }
        return toReturn
    }
}