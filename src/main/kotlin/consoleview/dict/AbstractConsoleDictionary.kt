package consoleview.dict

import consoleview.ViewDecorator
import model.AbstractEntity
import repo.AbstractRepo

abstract class AbstractConsoleDictionary<E, R>(val parentId: Int) :
    ViewDecorator where E: AbstractEntity, R: AbstractRepo<E> {

    abstract val repo: R
    abstract val model: Set<E>

    override fun show() {

        var idx = 0
        model
            .map { entity -> String.format("%d. %s", ++idx, entity.name) }
            .forEach { println(it) }
    }


}