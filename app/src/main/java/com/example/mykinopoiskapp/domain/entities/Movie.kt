package com.example.mykinopoiskapp.domain.entities

data class Movie(
    val id: Int,
    val title: String,
    val rating: Double,
    val posterUrl: String,
    val movieLength: Int,
    val year: Int,
    val description: String? = null
)
