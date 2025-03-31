package consoleview.dict

import consoleview.ViewDecorator
import consoleview.edit.NoteEditor
import model.Note
import repo.ArchiveRepo
import repo.NoteRepo
import java.util.Scanner

class NoteDictionary(override val model: Set<Note>, parentId: Int) : AbstractConsoleDictionary<Note, NoteRepo>(parentId) {

    override val repo = NoteRepo

    override fun forward(input: String): ViewDecorator {

        when(input) {
            "back" -> {
                println("назад")
                return ArchiveDictionary()
            }
            "new" -> {
                println("---Создание заметки---")
                println("Введите имя заметки")
                val name = Scanner(System.`in`).nextLine().trim()

                println("Введите текст заметки")
                val text = Scanner(System.`in`).nextLine().trim()

                var archive = ArchiveRepo.getById(parentId)
                repo.save(Note(name, text), archive)

                archive = ArchiveRepo.getById(parentId)
                println("+++ Заметка успешно создана +++")
                return NoteDictionary(archive.notes.values.toSet(), parentId)
            }
            else -> {
                val selected = repo.getByParentIdAndName(input, parentId)
                if(selected == null) {
                    println("Введено не существующее имя заметки")
                    return this
                }
                return NoteEditor(selected)
            }
        }

    }

    override fun show() {
        println("---Выберите заметку---")
        println("---- back для возврата в список архивов")
        println("---- new для создания новой заметки")

        super.show()
    }
}