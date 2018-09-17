package pl.mendroch.crossplatform.web.views

import org.w3c.dom.events.Event
import pl.mendroch.crossplatform.web.components.materialBottomNavigation
import pl.mendroch.crossplatform.web.components.materialBottomNavigationAction
import pl.mendroch.crossplatform.web.components.materialIcon
import react.*
import react.dom.div

interface BaseViewState : RState {
    var tab: String
}

class BaseView : RComponent<RProps, BaseViewState>() {
    override fun BaseViewState.init() {
        tab = "list"
    }

    override fun RBuilder.render() {
        div(classes = "main") {
            div(classes = "content") {
                when (state.tab) {
                    "download" -> downloadView()
                    "table" -> tableCarouselView()
                    else -> {
                        listView()
                    }
                }
            }
            div(classes = "bottom-navigation") {
                materialBottomNavigation {
                    attrs {
                        className = "navigation"
                        value = state.tab
                        onChange = { event: Event, value: Any ->
                            setState { tab = value.toString() }
                        }
                    }
                    materialBottomNavigationAction {
                        attrs {
                            icon = materialIcon { +"list" }
                            label = "List"
                            value = "list"
                        }
                    }
                    materialBottomNavigationAction {
                        attrs {
                            icon = materialIcon { +"grid_on" }
                            label = "Table"
                            value = "table"
                        }
                    }
                    materialBottomNavigationAction {
                        attrs {
                            icon = materialIcon { +"archive" }
                            label = "Download"
                            value = "download"
                        }
                    }
                }
            }
        }
    }
}