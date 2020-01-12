package kz.iitu.mymusic.networking

import com.google.gson.annotations.SerializedName

data class Track(
    val track: List<Track>,

    @SerializedName("strTrack") val track_name: String,
    @SerializedName("strAlbum") val track_album_name: String,
    @SerializedName("intDuration") val track_duration: Int,
    @SerializedName("strGenre") val track_genre: String,
    @SerializedName("strMood") val track_mood:String,
    @SerializedName("strTrackThumb") val track_thumbnail: String
)
data class TrackResponse(
    val track: List<Track>
)
