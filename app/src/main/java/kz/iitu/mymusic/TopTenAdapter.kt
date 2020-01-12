package kz.iitu.mymusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_album_details.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.layout_album_details.view.*
import kotlinx.android.synthetic.main.layout_album_info.view.*
import kotlinx.android.synthetic.main.layout_artist_info.view.*
import kotlinx.android.synthetic.main.layout_top_ten_track.view.*
import kz.iitu.mymusic.networking.Album
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.ArtistResponse
import kz.iitu.mymusic.networking.Track

class TopTenAdapter(
    private val track: List<Track?> = listOf()
) : RecyclerView.Adapter<TopTenAdapter.TopTenViewHolder>() {

    class TopTenViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindMessage(track: Track?) {
            view.album_name_fragmentHome_topTen.text = track?.track_album_name
            view.trackName_fragmentHome_topten.text = track?.track_name
            view.duration_fragmentHome_topTen.text = track?.track_duration.toString()
            Picasso.get().load(track?.track_thumbnail).into(view.thumbnail_fragmentHome_topTen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopTenViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_top_ten_track,parent,false))


    override fun getItemCount() = track.size

    override fun onBindViewHolder(holder: TopTenAdapter.TopTenViewHolder, position: Int) {
        holder.bindMessage(track[position])
    }
}