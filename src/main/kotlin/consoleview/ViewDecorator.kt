package consoleview

interface ViewDecorator {

    fun show() : Int
    fun forward(input: Int): ViewDecorator?

}