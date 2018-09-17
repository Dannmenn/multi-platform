package pl.mendroch.crossplatform.server

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.routing.Routing

fun Application.main() {
    install(CORS) {
        anyHost()
    }
    install(Routing) {
        api()
    }
}