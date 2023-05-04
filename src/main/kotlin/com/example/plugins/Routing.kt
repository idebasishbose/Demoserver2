package com.example.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import java.io.File

fun Application.configureRouting() {
    install(Routing) {
        get("/") {
            call.respondText("Hello World!!")
        }
        get("/users/{username}") {
            val userName = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (userName == "Admin") {
                call.response.header("CustomHeader", "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $userName!!")
        }
        staticResources("/static", "assets")
    }
}
