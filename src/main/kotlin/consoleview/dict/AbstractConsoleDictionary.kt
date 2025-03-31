package consoleview.dict

import consoleview.ViewDecorator
import model.AbstractEntity
import repo.AbstractRepo

abstract class AbstractConsoleDictionary<E, R>(val parentId: Int) :
    ViewDecorator where E: AbstractEntity, R: AbstractRepo<E> {

    abstract val repo: R
    abstract val model: List<E>

    override fun show() : Int {

        var idx = 0
        model.forEach { println( "${++idx}. ${it.name}") }
        return idx
    }

}