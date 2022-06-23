package com.mldz.movieapp.presentation.movieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mldz.core.usecases.FetchMovies
import com.mldz.core.usecases.GetMovies
import com.mldz.data2.api.RetrofitBuilder
import com.mldz.data2.db.AppDatabase
import com.mldz.data2.mappers.MovieApiMapper
import com.mldz.data2.mappers.MovieEntityMapper
import com.mldz.data2.repositories.movie.MovieLocalDataSourceImpl
import com.mldz.data2.repositories.movie.MovieRemoteDataSourceImpl
import com.mldz.data2.repositories.movie.MovieRepositoryImpl
import com.mldz.movieapp.databinding.FragmentMovieListBinding
import kotlinx.coroutines.Dispatchers


class FragmentMoviesList: Fragment() {
    private val viewModelFactory by lazy {
        MovieListViewModel.Factory(
            GetMovies(
                MovieRepositoryImpl(
                    MovieRemoteDataSourceImpl(
                        RetrofitBuilder.apiService,
                        MovieApiMapper()
                    ),
                    MovieLocalDataSourceImpl(
                        AppDatabase.getInstance(requireContext()).movieDao,
                        Dispatchers.IO,
                        MovieEntityMapper()
                    )
                )
            ),
            FetchMovies(
                MovieRepositoryImpl(
                    MovieRemoteDataSourceImpl(
                        RetrofitBuilder.apiService,
                        MovieApiMapper()
                    ),
                    MovieLocalDataSourceImpl(
                        AppDatabase.getInstance(requireContext()).movieDao,
                        Dispatchers.IO,
                        MovieEntityMapper()
                    )
                )
            )
        )
    }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory).get(MovieListViewModel::class.java)
    }

    private lateinit var binding: FragmentMovieListBinding

    private var movieClickListener: OnMovieClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MovieListAdapter{ item -> movieClickListener?.onItemClick(item) }
        binding.rvMovieList.layoutManager = GridLayoutManager(context, 2)
        binding.rvMovieList.adapter = adapter
        loadDataToAdapter(adapter)
    }

    private fun loadDataToAdapter(adapter: MovieListAdapter) {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            setLoading(it)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLoading(isLoading: Boolean) {
        when (isLoading) {
            true -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.rvMovieList.visibility = View.GONE
            }
            false -> {
                binding.progressBar.visibility = View.GONE
                binding.rvMovieList.visibility = View.VISIBLE
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieClick) {
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

    interface OnMovieClick {
        fun onItemClick(movieId: String)
    }
}