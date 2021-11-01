package com.mldz.movieapp.list

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
import com.mldz.movieapp.models.MovieData
import com.mldz.movieapp.R


class MovieListAdapter(private val onClickCard: (item: MovieData) -> Unit): ListAdapter<MovieData, MovieListAdapter.MovieViewHolder>(DiffCallback()) {
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

        fun bind(movieData: MovieData, onClickCard: (item: MovieData) -> Unit) {
            title.text = movieData.title
            genre.text = movieData.genre
            reviews.text = itemView.context.getString(R.string.reviews, movieData.reviewsCount)
            duration.text = itemView.context.getString(R.string.movies_list_film_time, movieData.duration)
            poster.setImageResource(movieData.poster)
            age.text = movieData.age.toString()

            if (movieData.isLiked) {
                ImageViewCompat.setImageTintList(
                        like, ColorStateList.valueOf(
                        ContextCompat.getColor(like.context, R.color.radical_red)
                    )
                )
            }

            starsImages.forEachIndexed { index, imageView ->
                val colorId = if (movieData.rating > index) R.color.radical_red else R.color.storm_gray
                ImageViewCompat.setImageTintList(
                        imageView, ColorStateList.valueOf(
                        ContextCompat.getColor(imageView.context, colorId)
                    )
                )
            }

            container.setOnClickListener{
                onClickCard(movieData)
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<MovieData>() {
        override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
            return oldItem == newItem
        }

    }
}