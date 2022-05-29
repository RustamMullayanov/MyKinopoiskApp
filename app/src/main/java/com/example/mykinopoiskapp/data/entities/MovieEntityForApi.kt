package com.example.mykinopoiskapp.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieEntityForApi(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String? = "",

    @SerialName("rating")
    val rating: Rating? = null,

    @SerialName("movieLength")
    val movieLength: Int? = 0,

    @SerialName("poster")
    val poster: Poster? = null,

    @SerialName("year")
    val year: Int? = 0,

    @SerialName("persons")
    val persons: List<PersonEntityForApi>? = null,

    @SerialName("description")
    val description: String? = ""
) {
    @Serializable
    data class Rating(@SerialName("kp") val ratingKp: Double?)

    @Serializable
    data class Poster(@SerialName("url") val url: String?)

    @Serializable
    data class PersonEntityForApi(

        @SerialName("id")
        val id: Int?,

        @SerialName("name")
        val name: String?,

        @SerialName("photo")
        val photo: String?,

        @SerialName("enProfession")
        val profession: String?
    )
}






