package com.mldz.movieapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class FragmentMoviesList: Fragment() {
    private var movieClickListener: onMovieClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onMovieClick) {
            movieClickListener = context
        }
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<ViewGroup>(R.id.movies_list_item_layout)?.setOnClickListener {
            movieClickListener?.onItemClick()
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
        fun onItemClick()
    }
}