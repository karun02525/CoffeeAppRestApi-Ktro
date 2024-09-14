package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Flower(
    val id:Int,
    val name:String,
    val color:String,
    val type:String
)