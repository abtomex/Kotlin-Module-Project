package consoleview.edit

import consoleview.ViewDecorator
import consoleview.dict.NoteDictionary
import model.Note
import repo.ArchiveRepo
import repo.NoteRepo

class NoteEditor(override val model: Note) : AbstractConsoleEditor<Note, NoteRepo>() {

    override val repo = NoteRepo

    override fun show() : Int {
        println("---Заметка---")
        println(model)
        println("-------------")
        println("0. Для возврата в список заметок")
        return 0
    }


    override fun forward(input: Int): ViewDecorator {
        return NoteDictionary(repo.getByParentId(model.parentId).toList(), model.parentId, ArchiveRepo.getById(model.parentId).name)
    }


}