package pl.mendroch.crossplatform.web.views

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.web.components.materialAppBar
import pl.mendroch.crossplatform.web.components.materialIcon
import pl.mendroch.crossplatform.web.components.materialToolbar
import react.*
import react.dom.*
import react.router.dom.RouteResultProps
import react.router.dom.routeLink

interface ListObjectViewProps : RProps {
    var id: String
}

interface ListObjectViewState : RState {
    var item: ListObject
}

class ListObjectView : RComponent<RouteResultProps<ListObjectViewProps>, ListObjectViewState>() {
    private val dataProvider = ListDataProvider(HttpUtil.HTTP_UTIL)

    override fun componentWillMount() {
        GlobalScope.launch {
            val listObject = dataProvider.getObject(props.match.params.id)
            setState { item = listObject }
        }
    }

    override fun RBuilder.render() {
        div {
            materialAppBar {
                attrs {
                    color = "primary"
                }
                materialToolbar {
                    span(classes = "toolbar-icon") {
                        routeLink(to = "/") {
                            materialIcon { +"arrow_back" }
                        }
                    }
                    h4(classes = "toolbar-title") { +"List Item object" }
                }
            }
            if (state.item == undefined) {
                +"loading"
            } else {
                val item = state.item
                div(classes = "list-object") {
                    h1 {
                        +item.name
                    }
                    h2 {
                        +"address: ${item.address}, phone: ${item.address}"
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
}