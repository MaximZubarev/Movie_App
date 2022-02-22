package com.mldz.movieapp.presentation.moviesdetails

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mldz.core.data.MovieRepository
import com.mldz.core.domain.MovieDetails
import com.mldz.core.usecases.GetMovie
import com.mldz.movieapp.R
import com.mldz.movieapp.databinding.FragmentMovieDetailsBinding
import com.mldz.movieapp.framework.remote.RemoteDataSource
import com.mldz.movieapp.framework.remote.RetrofitBuilder
import com.mldz.movieapp.utils.Constants
import com.mldz.movieapp.utils.Status
import kotlin.math.ceil

class FragmentMovieDetails : Fragment() {
    private val viewModelFactory by lazy { MovieDetailsViewModel.Factory(
        GetMovie(MovieRepository(RemoteDataSource(RetrofitBuilder.apiService)))
    ) }
    private val viewModel by lazy { ViewModelProvider(requireActivity(), viewModelFactory).get(MovieDetailsViewModel::class.java) }

    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getSerializable(PARAM_MOVIE_DATA) as? Long ?: return

        val adapter = ActorListAdapter()
        binding.rvActorList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvActorList.adapter = adapter

        loadMovie(movieId, adapter)
    }

    private fun loadMovie(movieId: Long, adapter: ActorListAdapter) {
        viewModel.loadMovie(movieId)
        viewModel.movie.observe(viewLifecycleOwner, {
            run {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            updateMovieDetailsInfo(it.data!!)
//                            adapter.submitList(movie.actors)
                        }
                        Status.ERROR -> {
                            showMovieNotFoundError(it.message)
                        }
                        Status.LOADING -> {

                        }
                    }
                }
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, {
            showProgressBar(it)
        })
    }

    private fun updateMovieDetailsInfo(movie: MovieDetails) {
        view?.findViewById<ImageView>(R.id.imageView)
                ?.load(Constants.POSTER_URL + movie.image)

//        val age = if (movie.adult!!) 18 else 12

//        view?.findViewById<TextView>(R.id.age)?.text = context?.getString(R.string.age, age)

        view?.findViewById<TextView>(R.id.movie_title)?.text = movie.title
        view?.findViewById<TextView>(R.id.genre)?.text = movie.genres.joinToString { it.name.toString() }
        view?.findViewById<TextView>(R.id.reviews)?.text = context?.getString(R.string.reviews, movie.reviewsCount)
        view?.findViewById<TextView>(R.id.description)?.text = movie.story

        val starsImages = listOf<ImageView?>(
                view?.findViewById(R.id.star1),
                view?.findViewById(R.id.star2),
                view?.findViewById(R.id.star3),
                view?.findViewById(R.id.star4),
                view?.findViewById(R.id.star5)
        )
        starsImages.forEachIndexed { index, imageView ->
            imageView?.let {
                val colorId = if (ceil((movie.rating.div(2))) > index)
                    R.color.radical_red
                else
                    R.color.storm_gray
                ImageViewCompat.setImageTintList(
                        imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, colorId)
                    )
                )
            }
        }
    }

    private fun showMovieNotFoundError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG)
            .show()
    }

    private fun showProgressBar(show: Boolean) {
        when (show) {
            true -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.scrollView.visibility = View.GONE
            }
            false -> {
                binding.progressBar.visibility = View.GONE
                binding.scrollView.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        private const val PARAM_MOVIE_DATA = "movie_data"

        @JvmStatic
        fun newInstance(movieId: Long) =
                FragmentMovieDetails().apply {
                    arguments = bundleOf(
                            PARAM_MOVIE_DATA to movieId
                    )
                }
    }
}