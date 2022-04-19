package com.example.mykinopoiskapp.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MovieEntityForApi(

    @SerialName("id_kinopoisk")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("rating_kinopoisk")
    val rating: Double,

    @SerialName("poster")
    val posterUrl: String,

    @SerialName("year")
    val year: Int,

    @SerialName("actors")
    val actors: List<String>,

    @SerialName("producers")
    val producers: List<String>,

    @SerialName("genres")
    val genres: List<String>,

    @SerialName("countries")
    val countries: List<String>,

    @SerialName("description")
    val description: String
)