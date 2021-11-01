package com.mldz.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mldz.movieapp.features.moviesdetails.FragmentMovieDetails
import com.mldz.movieapp.features.movieslist.FragmentMoviesList
import com.mldz.movieapp.models.MovieData

class MainActivity : AppCompatActivity(), FragmentMoviesList.onMovieClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(FragmentMoviesList.newInstance(), false)
    }

    private fun replaceFragment(fragment: Fragment, backStack: Boolean) {
        supportFragmentManager.beginTransaction()
                .apply {
                    replace(R.id.frame_container, fragment, null)
                    if (backStack) {
                        addToBackStack(null)
                    }
                    commit()
                }
    }

    override fun onItemClick(movie: MovieData) {
        replaceFragment(FragmentMovieDetails.newInstance(movie), true)
    }
}