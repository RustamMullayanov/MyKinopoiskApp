package com.example.mykinopoiskapp.data.entities

data class MovieEntityForDB(
    val id: Int,
    val title: String,
    val rating: Double,
    val posterUrl: String,
    val movieLength: Int,
    val year: Int,
    val actors: List<ActorEntityForDB>,
    val description: String
){
    data class ActorEntityForDB(
        val id: Int,
        val name: String,
        val photo: String,
    )
}
