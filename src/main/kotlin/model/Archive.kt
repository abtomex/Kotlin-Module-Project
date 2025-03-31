package model

import java.util.TreeMap

class Archive(name: String): AbstractEntity(name, 0) {
    val notes: MutableMap<String, Note> = TreeMap(String.CASE_INSENSITIVE_ORDER)

    override fun toString(): String {
        val notesBuilder = StringBuilder()
        var idx = 0
        this.notes.keys.forEach { name -> notesBuilder.append(String.format("%d. %s\n", ++idx, name))}
        return String.format("Заметки архива \"$name\": \n$notesBuilder")
    }
}