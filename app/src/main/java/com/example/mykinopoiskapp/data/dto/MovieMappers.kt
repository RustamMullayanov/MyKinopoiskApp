package com.example.mykinopoiskapp.data.dto

import com.example.mykinopoiskapp.data.entities.MovieEntityForApi
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB
import com.example.mykinopoiskapp.domain.entities.Movie

fun Movie.toDb(): MovieEntityForDB =
    MovieEntityForDB(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterUrl = this.posterUrl,
        year = this.year,
        actors = this.actors,
        producers = this.producers,
        genres = this.genres,
        countries = this.countries,
        description = this.description
    )

fun MovieEntityForDB.toDomain(): Movie =
    Movie(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterUrl = this.posterUrl,
        year = this.year,
        actors = this.actors,
        producers = this.producers,
        genres = this.genres,
        countries = this.countries,
        description = this.description
    )

fun MovieEntityForApi.toDomain(): Movie =
    Movie(
        id = this.id,
        title = this.title,
        rating = this.rating,
        posterUrl = this.posterUrl,
        year = this.year,
        actors = this.actors,
        producers = this.producers,
        genres = this.genres,
        countries = this.countries,
        description = this.description
    )