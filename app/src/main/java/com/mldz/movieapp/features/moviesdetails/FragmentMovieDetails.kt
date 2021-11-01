package com.mldz.movieapp.features.moviesdetails

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mldz.movieapp.R
import com.mldz.movieapp.models.MovieData

class FragmentMovieDetails : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieData = arguments?.getSerializable(PARAM_MOVIE_DATA) as? MovieData ?: return
        updateMovieDetailsInfo(movieData)

        val adapter = ActorListAdapter()
        val actorsList = view.findViewById<RecyclerView>(R.id.rv_actor_list)
        actorsList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        actorsList.adapter = adapter
        adapter.submitList(movieData.actors)
    }

    private fun updateMovieDetailsInfo(movieData: MovieData) {
        view?.findViewById<ImageView>(R.id.imageView)
                ?.setImageResource(movieData.poster)

        view?.findViewById<TextView>(R.id.age)?.text = context?.getString(R.string.age, movieData.age)

        view?.findViewById<TextView>(R.id.movie_title)?.text = movieData.title
        view?.findViewById<TextView>(R.id.genre)?.text = movieData.genre
        view?.findViewById<TextView>(R.id.reviews)?.text = context?.getString(R.string.reviews, movieData.reviewsCount)
        view?.findViewById<TextView>(R.id.description)?.text = movieData.description

        val starsImages = listOf<ImageView?>(
                view?.findViewById(R.id.star1),
                view?.findViewById(R.id.star2),
                view?.findViewById(R.id.star3),
                view?.findViewById(R.id.star4),
                view?.findViewById(R.id.star5)
        )
        starsImages.forEachIndexed { index, imageView ->
            imageView?.let {
                val colorId =
                        if (movieData.rating > index) R.color.radical_red else R.color.storm_gray
                ImageViewCompat.setImageTintList(
                        imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, colorId)
                )
                )
            }
        }
    }

    companion object {
        private const val PARAM_MOVIE_DATA = "movie_data"

        @JvmStatic
        fun newInstance(movieData: MovieData) =
                FragmentMovieDetails().apply {
                    arguments = bundleOf(
                            PARAM_MOVIE_DATA to movieData
                    )
                }
    }
}