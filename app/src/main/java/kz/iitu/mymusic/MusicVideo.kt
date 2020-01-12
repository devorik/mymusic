package kz.iitu.mymusic

import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_album_details.*
import kotlinx.android.synthetic.main.activity_music_video.*
import kotlinx.android.synthetic.main.favourites_fragment.*
import kotlinx.android.synthetic.main.fragment_home.*
import kz.iitu.mymusic.networking.Api
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.Track
import kz.iitu.mymusic.networking.Videos
import retrofit2.Call
import retrofit2.Response

class MusicVideo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_video)

        val actionbar = supportActionBar
        //set actionbar title
        actionbar?.title = "Music Videos"
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
        video_view.layoutManager = LinearLayoutManager(this)

        setUpViews()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpViews() {

        val id = intent.getIntExtra("id",0)
        val name = intent.getStringExtra("name")

        Api.getApiClient()
            .getVideo(id)
            .enqueue(object : retrofit2.Callback<Videos> {
                override fun onResponse(
                    call: Call<Videos>,
                    response: Response<Videos>
                ) {
                    val artistResponse = response.body()!!.mvids
                    Log.d("taaag", artistResponse.toString())
                    video_view.adapter = VideosAdapter(video = artistResponse,
                            onMusicClick = {
                                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it.mvid)))
                            }
                        )
                }

                override fun onFailure(call: Call<Videos>, t: Throwable) {
                    Log.d("taaag",t.message!!)
                }
            }
            )

        add_favour_btn.setOnClickListener {
            Api.getApiClient()
                .getAllArtists(name!!)
                .enqueue(object : retrofit2.Callback<Artist> {
                    override fun onResponse(
                        call: Call<Artist>,
                        response: Response<Artist>
                    ) {

                        val id = response.body()?.id
                        val artistname = response.body()?.artistName
                        val art_thumb = response.body()?.thumbnail
                        val art_genre = response.body()?.genre
                        val art_year = response.body()?.bornYear

                        //list_view_fragmentfav.layoutManager = LinearLayoutManager(this@MusicVideo)

                        AsyncTask.execute {
                           AppDatabase.getInstance(applicationContext)!!
                               .getFavouritesDao()
                               .insertFavourites(Favourites(
                                   id,
                                   art_name = artistname!!,
                                   art_thumbnail = art_thumb!!,
                                   art_year = art_year.toString(),
                                   art_genre = art_genre!!
                                   ))
                        }
                        Toast.makeText(this@MusicVideo,"Added",Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<Artist>, t: Throwable) {
                        Log.d("taaag",t.message!!)
                    }
                }
                )
        }


    }

}
