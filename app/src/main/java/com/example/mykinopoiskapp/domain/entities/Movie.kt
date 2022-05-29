package com.example.mykinopoiskapp.domain.entities

data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val posterUrl: String,
    val movieLength: Int,
    val genres: String,
    val country: String,
    val year: Int,
    val actors: List<Actor>,
    val description: String? = null
)
