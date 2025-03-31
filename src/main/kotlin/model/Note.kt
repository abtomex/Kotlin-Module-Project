package model

class Note(name: String, var text: String = "", parentId: Int = 0): AbstractEntity(name, parentId), Comparable<Note> {

    constructor(name: String, text: String) : this(name) {
        this.text = text
    }

    override fun compareTo(other: Note): Int {
        when(this.parentId.compareTo(other.parentId)) {
            in 1..Int.MAX_VALUE -> return 1
            in Int.MIN_VALUE .. -1 -> return -1
            0 -> {
                return this.name.compareTo(other.name)
            }

        }
        return 0
    }

    override fun toString(): String {
        return "Заметка $name\n$text"
    }


}