package kz.iitu.mymusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_album_details.view.*

import kz.iitu.mymusic.networking.Album


class AlbumDetailsAdapter(
    private val albums: List<Album?> = listOf()
) : RecyclerView.Adapter<AlbumDetailsAdapter.AlbumDetailsViewHolder>() {

    class AlbumDetailsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindMessage(album: Album?) {
            Picasso.get().load(album?.thumbnail).into(view.album_details_thumbnail)
            view.album_name_album_details.text = album?.alb_name
            view.artist_album_details.text = album?.art_name
            view.description.text = album?.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumDetailsViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_album_details,parent,false))


    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumDetailsAdapter.AlbumDetailsViewHolder, position: Int) {
        holder.bindMessage(albums[position])
    }
}