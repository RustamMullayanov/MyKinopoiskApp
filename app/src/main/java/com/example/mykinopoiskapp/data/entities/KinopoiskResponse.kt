package com.example.mykinopoiskapp.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KinopoiskResponse(@SerialName("docs") val movies: List<MovieEntityForApi>)
