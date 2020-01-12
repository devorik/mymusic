package kz.iitu.mymusic


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.layout_fav_info.view.*

class FavouritesAdapter(
    private val favourites: List<Favourites?> = listOf()
) : RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder>() {

     class FavouritesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindMessage(favourite: Favourites) {

            view.artName_favourites.text = favourite.art_name
            view.born_year_favourites.text = favourite.art_year
            view.genre_favourites.text = favourite.art_genre

            Picasso.get().load(favourite.art_thumbnail).into(view.thumbnail_favourites)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavouritesViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.layout_fav_info,parent,false))


    override fun getItemCount() = favourites.size

    @ExperimentalStdlibApi
    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        holder.bindMessage(favourites[position]!!)
    }
}