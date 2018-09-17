package pl.mendroch.crossplatform.desktop.utils

import javafx.scene.Node
import javafx.scene.control.ListCell
import javafx.scene.control.ListView
import javafx.scene.control.TextInputControl
import javafx.scene.input.Clipboard
import javafx.scene.input.ClipboardContent

fun copyToClipboard(node: Node) {
    when (node) {
        is ListCell<*> -> copyObjectToClipboard(node.item)
        is ListView<*> -> copyObjectToClipboard(node.selectionModel.selectedItem)
        is TextInputControl -> {
            val systemClipboard = Clipboard.getSystemClipboard()
            val content = ClipboardContent()
            if (node.selectedText.isNotEmpty()) {
                content.putString(node.selectedText)
            } else {
                content.putString(node.text)
            }
            systemClipboard.setContent(content)
        }
    }
}

fun copyObjectToClipboard(selectedItem: Any) {
    val systemClipboard = Clipboard.getSystemClipboard()
    val content = ClipboardContent()
    content.putString(selectedItem.toString())
    systemClipboard.setContent(content)
}