package consoleview.edit

import consoleview.ViewDecorator
import model.AbstractEntity
import repo.AbstractRepo

abstract class AbstractConsoleEditor<E, R> :
    ViewDecorator where E: AbstractEntity, R: AbstractRepo<E> {

    abstract val repo: R
    abstract val model: E

}