package kz.iitu.mymusic

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_album_details.*
import kotlinx.android.synthetic.main.activity_home_page.*

import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_album_info.view.*
import kz.iitu.mymusic.networking.Album
import kz.iitu.mymusic.networking.Api
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.Track
import retrofit2.Call
import retrofit2.Response

class AlbumDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

//        tracks_ofAlbum
        val actionbar = supportActionBar
        //set actionbar title
        actionbar?.title = "Album Information"
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
        tracks_ofAlbum.layoutManager = LinearLayoutManager(this)
        setUpViews()

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    private fun setUpViews() {
        albumName_fragmentAlbumInfo.text = intent.getStringExtra("albumName")
        art_name_fragmentAlbumInfo.text = intent.getStringExtra("artist")
        description_fragmentAlbumInfo.text = intent.getStringExtra("description")
        Picasso.get().load(intent.getStringExtra("thumbnail")).into(thumbnail_fragmentAlbumInfo)

        Api.getApiClient()
            .getAllTracks(intent.getIntExtra("id",0))
            .enqueue(object : retrofit2.Callback<Track> {
                override fun onResponse(
                    call: Call<Track>,
                    response: Response<Track>
                ) {
                    val artistResponse = response.body()!!.track
                    Log.d("taaag", artistResponse.toString())
                    tracks_ofAlbum.adapter = AllTrackAdapter(track = artistResponse)
                }

                override fun onFailure(call: Call<Track>, t: Throwable) {
                    Log.d("taaag",t.message!!)
                }
            }
            )

    }

}
