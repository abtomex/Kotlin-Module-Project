package consoleview.edit

import consoleview.ViewDecorator
import consoleview.dict.NoteDictionary
import model.Note
import repo.NoteRepo

class NoteEditor(override val model: Note) : AbstractConsoleEditor<Note, NoteRepo>() {

    override val repo = NoteRepo

    override fun show() {
        println(model)
    }

    override fun forward(input: String): ViewDecorator {
        return NoteDictionary(repo.getByParentId(model.parentId).toSet(), model.parentId)
    }


}