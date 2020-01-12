package kz.iitu.mymusic

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class Favourites(
    @PrimaryKey @ColumnInfo(name = "art_id") val id: Int? = null,
    @ColumnInfo(name = "art_name") val art_name: String,
    @ColumnInfo(name = "art_thumbnail") val art_thumbnail: String,
    @ColumnInfo(name = "art_genre") val art_genre: String,
    @ColumnInfo(name = "art_year") val art_year: String
)