package com.mldz.movieapp.features.movieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mldz.movieapp.R
import com.mldz.movieapp.data.JsonMovieRepository
import com.mldz.movieapp.list.MovieListAdapter
import com.mldz.movieapp.models.Movie


class FragmentMoviesList: Fragment() {
    private val viewModelFactory by lazy { MovieListViewModel.Factory(JsonMovieRepository(requireActivity())) }
    private val viewModel by lazy { ViewModelProvider(requireActivity(), viewModelFactory).get(MovieListViewModel::class.java) }

    private var movieClickListener: onMovieClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieList = view.findViewById<RecyclerView>(R.id.rv_movie_list)
        val adapter = MovieListAdapter{ item -> movieClickListener?.onItemClick(item) }
        movieList.layoutManager = GridLayoutManager(context, 2)
        movieList.adapter = adapter
        loadDataToAdapter(adapter)
    }

    private fun loadDataToAdapter(adapter: MovieListAdapter) {
        viewModel.movies.observe(viewLifecycleOwner, { movieList ->
            adapter.submitList(movieList)
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onMovieClick) {
            movieClickListener = context
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentMoviesList().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        movieClickListener = null
    }

    interface onMovieClick {
        fun onItemClick(movie: Movie)
    }
}