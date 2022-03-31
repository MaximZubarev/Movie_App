package com.mldz.movieapp.presentation.movieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mldz.core.data.MovieRepository
import com.mldz.core.usecases.GetMovies
import com.mldz.movieapp.databinding.FragmentMovieListBinding
import com.mldz.movieapp.framework.local.AppDatabase
import com.mldz.movieapp.framework.local.LocalDataSource
import com.mldz.movieapp.framework.remote.RemoteDataSource
import com.mldz.movieapp.framework.remote.RetrofitBuilder
import com.mldz.movieapp.utils.Status


class FragmentMoviesList: Fragment() {
    private val viewModelFactory by lazy {
        MovieListViewModel.Factory(
            GetMovies(MovieRepository(
                RemoteDataSource(RetrofitBuilder.apiService),
                LocalDataSource(AppDatabase.invoke(requireContext()).movieDao)
            ))
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
        viewModel.response.observe(viewLifecycleOwner, {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        adapter.submitList(resource.data!!)
                    }
                    Status.ERROR -> {

                    }
                    Status.LOADING -> {

                    }
                }
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, {
            setLoading(it)
        })
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
        fun onItemClick(movieId: Long)
    }
}