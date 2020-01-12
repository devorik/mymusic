package kz.iitu.mymusic

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouritesDao {

    @Insert
    fun insertFavourites(favourites: Favourites)

    @Query("SELECT * FROM favourites")
    fun getFavourites(): List<Favourites>

}