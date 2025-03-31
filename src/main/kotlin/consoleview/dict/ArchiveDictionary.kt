package consoleview.dict

import consoleview.ViewDecorator
import model.Archive
import repo.ArchiveRepo

class ArchiveDictionary : AbstractConsoleDictionary<Archive, ArchiveRepo>(0) {


    override val repo = ArchiveRepo
    override val model: Set<Archive> = repo.getAll()

    override fun forward(input: String): ViewDecorator? {

        if (input == "exit") return null
        val selected = repo.getOneByName(input)
        if(selected == null) {
            println("Введите корректное имя архива")
            return this
        }
        return NoteDictionary(selected.notes.values.toSet(), selected.id)
    }

    override fun show() {
        println("---Выберите архив---")
        println("---- exit для выхода из приложения")
        println("---- edit для редактирования")

        super.show()
    }
}