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
import kotlinx.android.synthetic.main.layout_video.view.*
import kz.iitu.mymusic.networking.*

class VideosAdapter(
    private val video: List<Videos?> = listOf(),
    private val onMusicClick: (Videos) -> Unit
) : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

    inner class VideosViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindMessage(video: Videos?) {
            view.trackName_mvids.text = video?.track_name
            view.music_video.text = video?.mvid
            Picasso.get().load(video?.thumbnail_track).into(view.thumbnail_mvids)

            view.setOnClickListener {
                onMusicClick(video!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VideosViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_video,parent,false))


    override fun getItemCount() = video.size

    override fun onBindViewHolder(holder: VideosAdapter.VideosViewHolder, position: Int) {
        holder.bindMessage(video[position])
    }
}