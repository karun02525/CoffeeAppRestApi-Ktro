package com.example

import com.example.api.flowerApi
import com.example.model.Flower
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.routing.routing

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    routing {
        flowerApi()
    }
}


object Output{
    val getFlowerList = listOf(
        Flower(1,"Rose","Red","Red"),
        Flower(2,"Lili","White","whote"),
        Flower(3,"Lotus","pink","ping"),
        Flower(4,"Koas","red","uni"),
    ).toMutableList()
}