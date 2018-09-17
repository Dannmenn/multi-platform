package pl.mendroch.crossplatform.desktop.view.list

import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.desktop.model.SimpleListObjectModel
import pl.mendroch.crossplatform.desktop.utils.copyToClipboard
import tornadofx.*

class ListFragment : ListCellFragment<ListObject>() {
    private val value = SimpleListObjectModel().bindTo(this)
    override val root = vbox {
        style {
            padding = box(5.px)
        }
        hbox {
            label(value.company)
            separator()
            label(value.name)
        }
        hbox {
            label(value.phone)
            separator()
            label(value.email)
            separator()
            label(value.date)
        }
        contextmenu {
            item("copy") {
                action {
                    copyToClipboard(parent)
                }
            }
        }
    }
}