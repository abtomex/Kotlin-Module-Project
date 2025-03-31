package consoleview.dict

import consoleview.ViewDecorator
import model.Archive
import repo.ArchiveRepo
import java.util.Scanner

class ArchiveDictionary : AbstractConsoleDictionary<Archive, ArchiveRepo>(0) {


    override val repo = ArchiveRepo
    override val model: Set<Archive> = repo.getAll()

    override fun forward(input: String): ViewDecorator? {

        when(input) {
            "new" -> {
                println("---Создание архива---")
                println("Введите имя архива")
                val name = Scanner(System.`in`).nextLine().trim()

                repo.save(Archive(name))
                println("+++ Архив успешно создан +++")
                return ArchiveDictionary()
            }
            "exit" -> return null
            else -> {
                val selected = repo.getOneByName(input)
                if(selected == null) {
                    println("! Введите корректное имя архива")
                    return this
                }
                return NoteDictionary(selected.notes.values.toSet(), selected.id)

            }
        }

    }

    override fun show() {
        println("---Выберите архив---")
        println("---- exit для выхода из приложения")
        println("---- new для добавления нового")

        super.show()
    }
}