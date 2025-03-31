package consoleview.dict

import consoleview.ViewDecorator
import model.Archive
import repo.ArchiveRepo
import java.util.Scanner

class ArchiveDictionary : AbstractConsoleDictionary<Archive, ArchiveRepo>(0) {


    override val repo = ArchiveRepo
    override val model: List<Archive> = repo.getAll().toList()

    override fun forward(input: Int): ViewDecorator? {

        when(input) {
            0 -> {
                println("---Создание архива---")
                println("Введите имя архива")
                val name = Scanner(System.`in`).nextLine().trim()
                if(name.isEmpty()) {
                    println("! Имя архива не может быть пустым")
                    return ArchiveDictionary()
                }

                repo.save(Archive(name))
                println("+++ Архив успешно создан +++")
                return ArchiveDictionary()
            }
            model.size + 1 -> return null
            else -> {
                if(input > model.size + 1) {
                    println("! Введите корректный номер архива")
                    return this
                }
                val selected = model[input-1]
                return NoteDictionary(selected.notes.values.toList(), selected.id, selected.name)

            }
        }

    }

    override fun show() : Int {
        println("---Выберите архив---")
        println("0. Добавить новый архив")
        val maxIdx = super.show()
        println("${maxIdx + 1}. Завершить приложение ")
        return 0
    }
}