package pl.mendroch.crossplatform.web.views

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.web.components.materialPaper
import react.*
import react.dom.li
import react.dom.p
import react.dom.ul
import react.router.dom.routeLink

interface ListViewState : RState {
    var items: Array<ListObject>
}

interface ListViewProps : RProps

class ListView : RComponent<ListViewProps, ListViewState>() {
    private val dataProvider = ListDataProvider(HttpUtil.HTTP_UTIL)
    override fun ListViewState.init() {
        items = emptyArray()
    }

    init {
        GlobalScope.launch {
            val objects = dataProvider.getData()
            setState { items = objects.list }
        }
    }

    override fun RBuilder.render() {
        ul(classes = "list-view") {
            for (item in state.items) {
                li {
                    routeLink(to = "/item/" + item._id) {
                        materialPaper {
                            p("header-p") {
                                +item.name
                            }
                            +"${item.about.substring(0, 120)}..."
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.listView() = child(ListView::class) {}