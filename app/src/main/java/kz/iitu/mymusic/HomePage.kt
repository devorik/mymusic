package kz.iitu.mymusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home_page.*
import kz.iitu.jauap.FavouritesFragment
import kz.iitu.jauap.HomeFragment
import kz.iitu.jauap.ProfileFragment

class HomePage : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {


    var drawerLayout: DrawerLayout? = null
    var toolbar: androidx.appcompat.widget.Toolbar? = null
    var navigationView: NavigationView? = null
    var toggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        drawerLayout = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar!!.setTitle("My Music")

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView!!.setCheckedItem(R.id.home)
        }

        toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.drawerOpen, R.string.drawerClose )

        drawerLayout?.run { addDrawerListener(toggle!!) }
        toggle!!.syncState()
        navigationView?.setNavigationItemSelectedListener(this)
        navigationView!!.setItemIconTintList(null)

        setUpViews()
    }

    private fun setUpViews(){
//        by_name_art_info.setOnClickListener {
//            startActivity(Intent(this,MainActivity::class.java))
//        }
//        top10_tracks.setOnClickListener {
//            startActivity(Intent(this,TopTenActivity::class.java))
//        }
//        art_albums.setOnClickListener {
//            startActivity(Intent(this,AlbumInfoActivity::class.java))
//        }
//        album_details.setOnClickListener {
//            startActivity(Intent(this,AlbumDetailsActivity::class.java))
//        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.Home -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.Favourites -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FavouritesFragment()).commit()
            R.id.Profile -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ProfileFragment()).commit()
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }
}
