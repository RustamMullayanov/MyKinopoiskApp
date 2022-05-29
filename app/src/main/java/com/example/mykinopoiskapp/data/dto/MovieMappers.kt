package com.example.mykinopoiskapp.data.dto

import com.example.mykinopoiskapp.data.entities.MovieEntityForApi
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB
import com.example.mykinopoiskapp.domain.entities.Movie

fun Movie.toDB(): MovieEntityForDB =
    MovieEntityForDB(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterUrl = this.posterUrl,
        movieLength = this.movieLength,
        genres = this.genres,
        country = this.country,
        year = this.year,
        actors = this.actors.map { it.toDB() },
        description = this.description!!
    )

fun MovieEntityForApi.toDomain(): Movie =
    Movie(
        id = this.id,
        title = this.name ?: "",
        rating = this.rating?.ratingKp ?: 0.0,
        posterUrl = this.poster?.url ?: "",
        movieLength = this.movieLength ?: 0,
        genres = this.genres?.map { it.name }
            ?.joinToString(separator = ", ", limit = 2, truncated = " ", postfix = " ") ?: "",
        country = this.countries?.map { it.name }?.first().toString(),
        year = this.year ?: 0,
        actors = this.persons?.filter { it.profession == "actor" }?.map { it.toDomain() }
            ?: emptyList(),
        description = this.description
    )