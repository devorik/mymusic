package kz.iitu.mymusic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_artist_info.view.*
import kz.iitu.mymusic.networking.Album
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.ArtistResponse

class ArtistAdapter(
    private val artists: List<Artist?> = listOf(),
    private val onArtistClick: (Artist) -> Unit
) : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    inner class ArtistViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        @ExperimentalStdlibApi
        fun bindMessage(artist: Artist?) {
            val id = artist?.id
            view.artName_fragmentHome.text = artist?.artistName
            view.born_year_fragmentHome.text = artist?.bornYear?.toString()
            view.genre_fragmentHome.text = artist?.genre
            view.website_fragment_Home.text = artist?.website

            Picasso.get().load(artist?.thumbnail).into(view.thumbnail_fragmentHome)

            view.setOnClickListener {
                onArtistClick(artist!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArtistViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_artist_info,parent,false))


    override fun getItemCount() = artists.size

    @ExperimentalStdlibApi
    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bindMessage(artists[position])
    }
}