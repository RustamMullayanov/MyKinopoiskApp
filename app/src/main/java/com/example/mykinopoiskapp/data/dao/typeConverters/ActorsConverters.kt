package com.example.mykinopoiskapp.data.dao.typeConverters

import androidx.room.TypeConverter
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB.ActorEntityForDB
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ActorsConverters {

    @TypeConverter
    fun gsonToActors(value: String?): List<ActorEntityForDB> {
        val type = object : TypeToken<List<ActorEntityForDB?>?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun actorsToGson(actors: List<ActorEntityForDB>): String = Gson().toJson(actors)
}