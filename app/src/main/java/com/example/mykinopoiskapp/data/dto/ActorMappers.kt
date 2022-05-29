package com.example.mykinopoiskapp.data.dto

import com.example.mykinopoiskapp.data.entities.MovieEntityForApi.PersonEntityForApi
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB.ActorEntityForDB
import com.example.mykinopoiskapp.domain.entities.Actor

fun PersonEntityForApi.toDomain(): Actor =
    Actor(
        id = this.id ?: 0,
        name = this.name ?: "",
        photo = this.photo ?: "",
    )

fun Actor.toDB(): ActorEntityForDB =
    ActorEntityForDB(
        id = this.id,
        name = this.name,
        photo = this.photo,
    )