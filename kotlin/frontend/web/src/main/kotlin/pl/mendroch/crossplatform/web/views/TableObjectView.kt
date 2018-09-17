package pl.mendroch.crossplatform.web.views

import pl.mendroch.crossplatform.common.model.TableObject
import pl.mendroch.crossplatform.web.components.materialPaper
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import react.dom.h2
import react.dom.p

interface TableObjectViewProps : RProps {
    var item: TableObject
}

class TableObjectView : RComponent<TableObjectViewProps, RState>() {
    override fun RBuilder.render() {
        val item = props.item
        div(classes = "table-object") {
            materialPaper {
                h1 {
                    +item.name
                }
                h2 {
                    +"address: ${item.address}, phone: ${item.phone}"
                }
                p {
                    +"index: ${item.index}, id: ${item._id}"
                }
                p {
                    +"email: ${item.email}, balance: ${item.balance}, age: ${item.age}"
                }
                p {
                    +"eyeColor: ${item.eyeColor}, date: ${item.registered.toDateFormatString()}, latitude: ${item.latitude}, longitude: ${item.longitude}"
                }
                p {
                    +"tags: ${item.tags}"
                }
                p {
                    +item.about
                }
            }
        }
    }
}

fun RBuilder.tableObjectView(item: TableObject) = child(TableObjectView::class) {
    attrs { this.item = item }
}