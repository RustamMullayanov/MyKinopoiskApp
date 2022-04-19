package com.example.mykinopoiskapp.data.entities

data class MovieEntityForDB(
    val id: Int,
    val title: String,
    val rating: Double,
    val posterUrl: String,
    val year: Int,
    val actors: List<String>,
    val producers: List<String>,
    val genres: List<String>,
    val countries: List<String>,
    val description: String
)
