package com.example.api

import com.example.Output.getFlowerList
import com.example.model.Flower
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route


fun Route.flowerApi(){
       route("api/flowers",Route::getFlowers)
       route("api/flower/{id}",Route::getFlowerById)
       route("api/add-flower",Route::addFlower)
}


private fun Route.getFlowers(){
    get {
       call.respond(
           HttpStatusCode.OK,
           getFlowerList
       )
    }
}

private fun Route.getFlowerById(){
    get {
        val id = call.parameters["id"]
        id?.let {flower->
            getFlowerList.find { it.id == flower.toInt() }?.let {
                call.respond(HttpStatusCode.OK,it)
            }
        }?: call.respond(HttpStatusCode.NoContent)
    }
}

private fun Route.addFlower(){
    post {
      val payload = call.receive<Flower>()
        getFlowerList.add(payload)
        call.respond(HttpStatusCode.OK,payload)
    }
}
