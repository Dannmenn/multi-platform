package pl.mendroch.crossplatform.desktop.view

import javafx.geometry.Side
import pl.mendroch.crossplatform.desktop.view.list.DesktopListView
import tornadofx.*

class MainContentView : View("Main content view") {
    override val root = drawer(side = Side.BOTTOM) {
        prefWidth = 1200.0
        minHeight = 800.0
        item(DesktopListView(), expanded = true)
        item(TableObjectView())
    }
}