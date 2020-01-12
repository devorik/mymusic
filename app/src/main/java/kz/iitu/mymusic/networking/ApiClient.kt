package kz.iitu.mymusic.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("search.php")
    fun getAllArtists(@Query("s") name: String): Call<Artist>

    @GET("track-top10.php")
    fun getTopTen(@Query("s") track: String):Call<Track>

    @GET("track.php")
    fun getAllTracks(@Query("m") track: Int):Call<Track>

    @GET("searchalbum.php")
    fun getAlbum(@Query("s" ) album: String):Call<Album>

    @GET("searchalbum.php")
    fun getAlbumByName(@Query("a" ) album: String):Call<Album>

    @GET("mvid.php")
    fun getVideo(@Query("i" ) id: Int):Call<Videos>
}