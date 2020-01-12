package kz.iitu.mymusic.networking

import com.google.gson.annotations.SerializedName

data class Artist(
    val artists: List<Artist>,

    @SerializedName("idArtist") val id: Int,
    @SerializedName("strArtist") val artistName: String,
    @SerializedName("intBornYear") val bornYear: Int,
    @SerializedName("strGenre") val genre: String,
    @SerializedName("strWebsite") val website: String,
    @SerializedName("strBiographyEN") val biography:String,
    @SerializedName("strArtistThumb") val thumbnail: String,
    @SerializedName("strArtistLogo") val logo: String
)

data class Videos(
    val mvids: List<Videos>,
    @SerializedName("strTrackThumb") val thumbnail_track: String,
    @SerializedName("strTrack") val track_name: String,
    @SerializedName("strMusicVid") val mvid: String
)

data class ArtistResponse(
    val artists: List<Artist>
)