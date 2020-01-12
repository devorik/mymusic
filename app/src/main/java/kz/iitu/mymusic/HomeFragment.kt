package kz.iitu.jauap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kz.iitu.mymusic.*
import kz.iitu.mymusic.networking.Album
import kz.iitu.mymusic.networking.Api
import kz.iitu.mymusic.networking.Artist
import kz.iitu.mymusic.networking.Track
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment() {
    private fun albumByName(){
        Api.getApiClient()
            .getAlbum(artist_name_fragmenHome_search.text.toString())
            .enqueue(object : retrofit2.Callback<Album> {
                override fun onResponse(
                    call: Call<Album>,
                    response: Response<Album>
                ) {
                    val artistResponse = response.body()!!.album
                    Log.d("taaag", artistResponse.toString())
                    album_info_view_fragmentHome_album.adapter = AlbumAdapter(albums = artistResponse,
                        onAlbumClick = {
                                val i = Intent(requireContext(),AlbumDetailsActivity::class.java)

                                i.putExtra("id",it.id)
                                i.putExtra("thumbnail",it.thumbnail)
                                i.putExtra("albumName",it.alb_name)
                                i.putExtra("artist",it.art_name)
                                i.putExtra("description",it.description)
                                startActivity(i)
//                            val manager: FragmentManager? = fragmentManager
//                            manager?.beginTransaction()
//                                ?.replace(R.id.fragment_container, albumInfo!!,albumInfo.tag)
//                                ?.commit()
                        }
                        )
                }

                override fun onFailure(call: Call<Album>, t: Throwable) {
                    Log.d("taaag",t.message!!)
                }
            }
            )
    }

    private fun topTenByName() {
        Api.getApiClient()
            .getTopTen(artist_name_fragmenHome_search.text.toString())
            .enqueue(object : retrofit2.Callback<Track> {
                override fun onResponse(
                    call: Call<Track>,
                    response: Response<Track>
                ) {
                    val artistResponse = response.body()!!.track
                    Log.d("taaag", artistResponse.toString())
                    top_ten_tracks_fragmentHome.adapter = TopTenAdapter(track = artistResponse)
                }

                override fun onFailure(call: Call<Track>, t: Throwable) {
                    Log.d("taaag",t.message!!)
                }
            }
            )
    }
    private fun artistByName(){
        Api.getApiClient()
            .getAllArtists(artist_name_fragmenHome_search.text.toString())
            .enqueue(object : retrofit2.Callback<Artist> {
                override fun onResponse(
                    call: Call<Artist>,
                    response: Response<Artist>
                ) {
                    val artistResponse = response.body()!!.artists

                    list_view_fragmentHome.adapter = ArtistAdapter(artists = artistResponse,
                        onArtistClick = {
                            val i = Intent(requireContext(),MusicVideo::class.java)
                            i.putExtra("id",it.id)
                            i.putExtra("name",it.artistName)
                            startActivity(i)
                        }
                        )
                }

                override fun onFailure(call: Call<Artist>, t: Throwable) {
                    Log.d("taaag",t.message!!)
                }
            }
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        list_view_fragmentHome.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        top_ten_tracks_fragmentHome.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        album_info_view_fragmentHome_album.layoutManager = LinearLayoutManager(requireContext())
        search_fragmentHome.setOnClickListener {
            artistByName()
            topTenByName()
            albumByName()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }
}