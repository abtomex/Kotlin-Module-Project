package consoleview.dict

import consoleview.ViewDecorator
import consoleview.edit.NoteEditor
import model.Note
import repo.ArchiveRepo
import repo.NoteRepo
import java.util.Scanner

class NoteDictionary(override val model: List<Note>, parentId: Int, val title: String) : AbstractConsoleDictionary<Note, NoteRepo>(parentId) {

    override val repo = NoteRepo

    override fun forward(input: Int): ViewDecorator {

        when(input) {

            0 -> {
                println("---Создание заметки---")
                println("Введите имя заметки")
                val name = Scanner(System.`in`).nextLine().trim()
                if(name.isEmpty()) {
                    println("! Имя заметки не может быть пустым")
                    return this
                }
                println("Введите текст заметки")
                val text = Scanner(System.`in`).nextLine().trim()
                if(text.isEmpty()) {
                    println("! Текст заметки не может быть пустым")
                    return this
                }
                var archive = ArchiveRepo.getById(parentId)
                repo.save(Note(name, text), archive)

                archive = ArchiveRepo.getById(parentId)
                println("+++ Заметка успешно создана +++")
                return NoteDictionary(archive.notes.values.toList(), parentId, archive.name)
            }
            model.size + 1 -> {
                println("назад")
                return ArchiveDictionary()
            }
            else -> {
                if(input > model.size + 1) {
                    println("Введите корректный номер заметки")
                    return this
                }
                val selected = model[input-1]
                return NoteEditor(selected)
            }
        }

    }

    override fun show() : Int {
        println("---${title}---")
        println("0. Создать заметку")

        val maxIdx = super.show()
        println("${maxIdx+1}. Вернуться к архивам")
        return 0
    }
}