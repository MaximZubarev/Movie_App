package com.mldz.movieapp.presentation.movieslist

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.mldz.core.domain.Movie
import com.mldz.movieapp.R
import com.mldz.movieapp.utils.Constants


class MovieListAdapter(private val onClickCard: (item: Long) -> Unit): ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(
    DiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position), onClickCard)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val container = itemView.findViewById<View>(R.id.movies_list_item_layout)
        private val title = itemView.findViewById<TextView>(R.id.movies_list_film_name_text)
        private val genre = itemView.findViewById<TextView>(R.id.movies_list_film_genre_text)
        private val reviews = itemView.findViewById<TextView>(R.id.movie_reviews_count_text)
        private val duration = itemView.findViewById<TextView>(R.id.movies_list_film_time_text)
        private val poster = itemView.findViewById<ImageView>(R.id.movies_list_header_image)
        private val age = itemView.findViewById<TextView>(R.id.movies_list_age)
        private val like = itemView.findViewById<ImageView>(R.id.iv_like)

        private val starsImages: List<ImageView> = listOf(
                itemView.findViewById(R.id.movie_rating_star1_image),
                itemView.findViewById(R.id.movie_rating_star2_image),
                itemView.findViewById(R.id.movie_rating_star3_image),
                itemView.findViewById(R.id.movie_rating_star4_image),
                itemView.findViewById(R.id.movie_rating_star5_image)
        )

        fun bind(movieListItem: Movie, onClickCard: (item: Long) -> Unit) {
            title.text = movieListItem.title
            genre.text = movieListItem.genres.joinToString { it.toString() }
            reviews.text = itemView.context.getString(R.string.reviews, movieListItem.reviewsCount)
//            duration.text = itemView.context.getString(R.string.movies_list_film_time, movie.runningTime)
//            age.text = movie.pgAge.toString()

            poster.load(Constants.POSTER_URL + movieListItem.image) {
                placeholder(R.drawable.movie_avengers)
                transformations(RoundedCornersTransformation(15f, 15f, 0f,0f))
            }
//
//            if (movie.isLiked) {
//                ImageViewCompat.setImageTintList(
//                        like, ColorStateList.valueOf(
//                        ContextCompat.getColor(like.context, R.color.radical_red)
//                    )
//                )
//            }

            starsImages.forEachIndexed { index, imageView ->
                val colorId = if ((movieListItem.reviewsCount / 2) > index) R.color.radical_red else R.color.storm_gray
                ImageViewCompat.setImageTintList(
                        imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, colorId)
                    )
                )
            }

            container.setOnClickListener{
                onClickCard(movieListItem.id)
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }
}