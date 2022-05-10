package com.example.mykinopoiskapp.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MovieEntityForApi(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String?,

    @SerialName("alternativeName")
    val alternativeName: String?,

    @SerialName("rating")
    val rating: Rating,

    @SerialName("poster")
    val poster: Poster,

    @SerialName("year")
    val year: Int? = 1000,

    @SerialName("description")
    val description: String? = ""
) {
    @Serializable
    data class Rating(@SerialName("kp") val ratingKp: Double)

    @Serializable
    data class Poster(@SerialName("url") val url: String)
}






