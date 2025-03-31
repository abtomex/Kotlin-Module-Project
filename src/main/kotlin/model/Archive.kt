package model

import java.util.TreeMap

class Archive(name: String): AbstractEntity(name, 0) {
    val notes: MutableMap<String, Note> = TreeMap(String.CASE_INSENSITIVE_ORDER)

}