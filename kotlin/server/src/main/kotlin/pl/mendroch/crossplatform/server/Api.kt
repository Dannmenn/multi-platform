package pl.mendroch.crossplatform.server

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondFile
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.serialization.json.JSON
import pl.mendroch.crossplatform.common.Endpoints.api
import pl.mendroch.crossplatform.common.Endpoints.big
import pl.mendroch.crossplatform.common.Endpoints.data
import pl.mendroch.crossplatform.common.Endpoints.files
import pl.mendroch.crossplatform.common.Endpoints.list
import pl.mendroch.crossplatform.common.Endpoints.listId
import pl.mendroch.crossplatform.common.Endpoints.small
import pl.mendroch.crossplatform.common.Endpoints.table
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.common.model.ListWrapper
import java.io.File

fun Routing.api() {
    val resource = File(javaClass.classLoader.getResource("generatedData.json").file)
    val listMap = HashMap<String, ListObject>()
    JSON().parse<ListWrapper>(resource.readText()).list.forEach { listMap[it._id] = it }
    route(api) {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
        route(files) {
            get(small) {
                call.respondFile(File(javaClass.classLoader.getResource("SmallFile.xlsx").file))
            }
            get(big) {
                call.respondFile(File(javaClass.classLoader.getResource("BigFile.xlsx").file))
            }
        }
        route(data) {
            get(listId) {
                val id = this.context.parameters["id"]
                val message = listMap[id]
                if (message != null) call.respond(JSON.stringify(message)) else call.respond(HttpStatusCode.NotFound)
            }
            get(list) {
                call.respondFile(File(javaClass.classLoader.getResource("generatedData.json").file))
            }
            get(table) {
                call.respondFile(File(javaClass.classLoader.getResource("generatedTableData.json").file))
            }
        }
    }
}