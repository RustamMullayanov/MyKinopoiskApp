package com.example.mykinopoiskapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MovieEntityForDB.TABLE_NAME)
data class MovieEntityForDB(

    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "poster_url")
    val posterUrl: String,

    @ColumnInfo(name = "length")
    val movieLength: Int,

    @ColumnInfo(name = "genres")
    val genres: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "year")
    val year: Int,

    val actors: List<ActorEntityForDB>,

    @ColumnInfo(name = "description")
    val description: String
) {

    data class ActorEntityForDB(
        val id: Int,
        val name: String,
        val photo: String,
    )

    companion object {
        const val TABLE_NAME = "movies"
    }
}
