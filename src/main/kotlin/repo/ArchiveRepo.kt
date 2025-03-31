package repo

import model.Archive
import java.util.TreeSet

object ArchiveRepo : AbstractRepo<Archive>() {

    override val collection: MutableSet<Archive> = TreeSet(compareBy { it.name.lowercase() })
    override fun thisType(): String {
        return "Архив"
    }

    override fun getAll(): Set<Archive> {
        return super.getAll().map { archive: Archive -> this.fillNotes(archive) }.toSet()
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