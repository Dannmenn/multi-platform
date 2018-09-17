package pl.mendroch.crossplatform.desktop

import pl.mendroch.crossplatform.common.Endpoints
import pl.mendroch.crossplatform.desktop.utils.HttpUtil
import pl.mendroch.crossplatform.desktop.view.ApplicationView
import pl.mendroch.crossplatform.utils.url
import tornadofx.*

class DesktopApplication : App(ApplicationView::class) {
    private val api: HttpUtil by inject()

    init {
        api.baseURI = url + Endpoints.api
    }
}