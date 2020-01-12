package kz.iitu.mymusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_album_info.view.*
import kotlinx.android.synthetic.main.layout_artist_info.view.*
import kz.iitu.mymusic.networking.Album
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.ArtistResponse

class AlbumAdapter(
    private val albums: List<Album?> = listOf(),
    private val onAlbumClick: (Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindMessage(album: Album?) {
            view.albumName_fragmentHome_album.text = album?.alb_name
            view.year_name_fragmentHome_album.text = album?.rel_year.toString()
            view.genre_fragmentHome_album.text = album?.genre
            Picasso.get().load(album?.thumbnail).into(view.thumbnail_fragmentHome_album)

            view.setOnClickListener {
                onAlbumClick(album!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_album_info,parent,false))


    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindMessage(albums[position])

    }
}