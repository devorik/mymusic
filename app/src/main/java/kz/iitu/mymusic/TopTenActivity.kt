package kz.iitu.mymusic

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_top_ten.*
import kz.iitu.mymusic.networking.Api
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.Track
import retrofit2.Call
import retrofit2.Response

class TopTenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_ten)

        top_ten_tracks.layoutManager = LinearLayoutManager(this)

        top_ten_button.setOnClickListener {
            topTenByName()
        }
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onNavigateUp()
    }
    private fun topTenByName() {
        Api.getApiClient()
            .getTopTen(top_tent_track_text_view.text.toString())
            .enqueue(object : retrofit2.Callback<Track> {
                override fun onResponse(
                    call: Call<Track>,
                    response: Response<Track>
                ) {
                    val artistResponse = response.body()!!.track
                    Log.d("taaag", artistResponse.toString())
                    top_ten_tracks.adapter = TopTenAdapter(track = artistResponse)
                }

                override fun onFailure(call: Call<Track>, t: Throwable) {
                    Log.d("taaag",t.message!!)
                }
            }
            )
    }
}
