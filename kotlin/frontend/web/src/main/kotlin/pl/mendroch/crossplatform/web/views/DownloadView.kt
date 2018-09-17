package pl.mendroch.crossplatform.web.views

import pl.mendroch.crossplatform.web.components.materialButton
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.p

class DownloadView : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div(classes = "download-view") {
            p {
                materialButton {
                    attrs {
                        href = "http://localhost:8080/api/v1/files/small"
                    }
                    +"Download small excel file"
                }
            }
            p {
                materialButton {
                    attrs {
                        href = "http://localhost:8080/api/v1/files/big"
                    }
                    +"Download big excel file"
                }
            }
        }
    }
}

fun RBuilder.downloadView() = child(DownloadView::class) {
}