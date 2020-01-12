package kz.iitu.jauap

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.favourites_fragment.*
import kotlinx.android.synthetic.main.fragment_home.*
import kz.iitu.mymusic.*
import kz.iitu.mymusic.networking.Api
import kz.iitu.mymusic.networking.Artist
import retrofit2.Call
import retrofit2.Response


class FavouritesFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list_view_fragment_fav.layoutManager = LinearLayoutManager(requireContext())

        AsyncTask.execute {
            val favourites = AppDatabase.getInstance(activity!!.applicationContext)!!.getFavouritesDao().getFavourites()

            activity!!.runOnUiThread {
                list_view_fragment_fav.adapter = FavouritesAdapter(favourites)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.favourites_fragment,container,false)
    }
}