package com.example.mykinopoiskapp.data.dto

import com.example.mykinopoiskapp.data.entities.MovieEntityForApi.ActorEntityForApi
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB.ActorEntityForDB
import com.example.mykinopoiskapp.domain.entities.Actor

fun ActorEntityForApi.toDomain(): Actor =
    Actor(
        id = this.id,
        name = this.name,
        photo = this.photo,
        description = this.description
    )

fun Actor.toDB(): ActorEntityForDB =
    ActorEntityForDB(
        id = this.id,
        name = this.name,
        photo = this.photo,
        description = this.description ?: ""
    )