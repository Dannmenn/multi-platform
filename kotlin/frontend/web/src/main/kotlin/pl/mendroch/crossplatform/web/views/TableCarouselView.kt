package pl.mendroch.crossplatform.web.views

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import kotlinx.html.js.onClickFunction
import pl.mendroch.crossplatform.common.model.TableObject
import pl.mendroch.crossplatform.respositories.TableDataProvider
import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.web.components.materialIcon
import react.*
import react.dom.a
import react.dom.div
import react.dom.span

interface TableCarouselViewState : RState {
    var activeIndex: Int
    var items: Array<TableObject>
}

class TableCarouselView : RComponent<RProps, TableCarouselViewState>() {
    private val dataProvider = TableDataProvider(HttpUtil.HTTP_UTIL)
    override fun TableCarouselViewState.init() {
        activeIndex = 0
        items = emptyArray()
    }

    init {
        GlobalScope.launch {
            val objects = dataProvider.getData()
            setState { items = objects.list }
        }
    }

    override fun RBuilder.render() {
        div(classes = "table-object-view") {
            val items = state.items
            val index = state.activeIndex
            if (items.isEmpty()) {
                +"Loading"
            } else {
                if (index > 0) {
                    a(classes = "link previous-link") {
                        attrs {
                            onClickFunction = { setState { activeIndex = index - 1 } }
                        }
                        materialIcon { +"navigate_before" }
                    }
                }
                tableObjectView(item = items[index])
                span(classes = "paging") { +"${index + 1}/${items.size}" }
                if (index < items.size) {
                    a(classes = "link next-link") {
                        attrs {
                            onClickFunction = { setState { activeIndex = index + 1 } }
                        }
                        materialIcon { +"navigate_next" }
                    }
                }
            }
        }
    }
}

fun RBuilder.tableCarouselView() = child(TableCarouselView::class) {
}