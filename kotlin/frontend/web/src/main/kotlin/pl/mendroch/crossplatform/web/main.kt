package pl.mendroch.crossplatform.web

import pl.mendroch.crossplatform.utils.HttpUtil
import pl.mendroch.crossplatform.web.views.BaseView
import pl.mendroch.crossplatform.web.views.ListObjectView
import react.dom.render
import react.router.dom.hashRouter
import react.router.dom.route
import react.router.dom.switch
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    HttpUtil.HTTP_UTIL.baseUrl = "http://localhost:8080/api/v1"
    window.onload = {
        render(document.getElementById("root")!!) {
            hashRouter {
                switch {
                    route("/item/:id", ListObjectView::class)
                    route("/", BaseView::class)
                }
            }
        }
    }
}