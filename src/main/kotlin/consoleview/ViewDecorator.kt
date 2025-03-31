package consoleview

interface ViewDecorator {

    fun show()
//    fun type(): ConsoleViewType
    fun forward(input: String): ViewDecorator?

}