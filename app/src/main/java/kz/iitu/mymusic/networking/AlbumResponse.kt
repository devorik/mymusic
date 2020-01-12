package kz.iitu.mymusic.networking

import com.google.gson.annotations.SerializedName

data class Album(
    val album: List<Album>,

    @SerializedName("idAlbum") val id: Int,
    @SerializedName("strAlbum") val alb_name: String,
    @SerializedName("intYearReleased") val rel_year: Int,
    @SerializedName("strGenre") val genre: String,
    @SerializedName("strAlbumThumb") val thumbnail: String,
    @SerializedName("strArtist") val art_name: String,
    @SerializedName("strDescriptionEN") val description: String
    )
data class AlbumResponses(
    val artists: List<Artist>
)
