package kz.iitu.jauap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_info.view.*
import kotlinx.android.synthetic.main.layout_artist_info.view.*
import kz.iitu.mymusic.R


class AlbumInfoFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val thumb = arguments!!.getString("thumbnail")
        val albumName = arguments!!.getString("albumName")
        val artist = arguments!!.getString("artist")
        val description = arguments!!.getString("description")



        view.albumName_fragmentAlbumInfo.text = albumName
        view.art_name_fragmentAlbumInfo.text = artist
        view.description_fragmentAlbumInfo.text = description

        Picasso.get().load(thumb).into(view.thumbnail_fragmentAlbumInfo)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_album_info,container,false)
    }
}