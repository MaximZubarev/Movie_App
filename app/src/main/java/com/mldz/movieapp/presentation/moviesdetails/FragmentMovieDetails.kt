package com.mldz.movieapp.presentation.moviesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mldz.core.entities.MovieDetails
import com.mldz.movieapp.R
import com.mldz.movieapp.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentMovieDetails : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding

    private val viewModel by viewModels<MovieDetailsViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = arguments?.getSerializable(PARAM_MOVIE_DATA) as? String ?: return

        val adapter = ActorListAdapter()
        binding.rvActorList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.rvActorList.adapter = adapter

        loadMovie(movieId, adapter)
    }

    private fun loadMovie(movieId: String, adapter: ActorListAdapter) {
        viewModel.loadMovie(movieId)
        viewModel.movie.observe(viewLifecycleOwner) {
            if (it.id.isEmpty()) {
                showMovieNotFoundError("")
            } else {
                updateMovieDetailsInfo(it)
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            showProgressBar(it)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateMovieDetailsInfo(movie: MovieDetails) {
        view?.findViewById<ImageView>(R.id.imageView)
                ?.load(movie.image)

//        val age = if (movie.adult!!) 18 else 12

//        view?.findViewById<TextView>(R.id.age)?.text = context?.getString(R.string.age, age)

        view?.findViewById<TextView>(R.id.movie_title)?.text = movie.title
        view?.findViewById<TextView>(R.id.genre)?.text = movie.genres
        view?.findViewById<TextView>(R.id.reviews)?.text = context?.getString(R.string.reviews, movie.imDbRatingVotes)
        view?.findViewById<TextView>(R.id.description)?.text = movie.plotLocal

//        val starsImages = listOf<ImageView?>(
//                view?.findViewById(R.id.star1),
//                view?.findViewById(R.id.star2),
//                view?.findViewById(R.id.star3),
//                view?.findViewById(R.id.star4),
//                view?.findViewById(R.id.star5)
//        )
//        starsImages.forEachIndexed { index, imageView ->
//            imageView?.let {
//                val colorId = if (ceil((movie.rating.div(2))) > index)
//                    R.color.radical_red
//                else
//                    R.color.storm_gray
//                ImageViewCompat.setImageTintList(
//                        imageView, ColorStateList.valueOf(
//                        ContextCompat.getColor(imageView.context, colorId)
//                    )
//                )
//            }
//        }
    }

    private fun showMovieNotFoundError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
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
        fun newInstance(movieId: String) =
                FragmentMovieDetails().apply {
                    arguments = bundleOf(
                            PARAM_MOVIE_DATA to movieId
                    )
                }
    }
}