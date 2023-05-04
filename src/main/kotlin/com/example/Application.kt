package com.example

import com.example.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(CallLogging)
    configureRouting()
}