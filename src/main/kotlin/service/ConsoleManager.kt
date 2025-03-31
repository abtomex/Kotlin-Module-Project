package service

import consoleview.dict.ArchiveDictionary
import consoleview.ViewDecorator
import java.util.Scanner

object ConsoleManager {


    fun showContentWithNavigation() {

        var consoleView: ViewDecorator? = ArchiveDictionary()

        do {

            consoleView?.show()
            val input = Scanner(System.`in`).nextInt()
            consoleView = consoleView?.forward(input)

        } while (consoleView != null)

    }

}