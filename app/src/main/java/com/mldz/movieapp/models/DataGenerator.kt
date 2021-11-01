package com.mldz.movieapp.models

import com.mldz.movieapp.R


object DataGenerator {
    fun generateMovieList() = arrayListOf(
            MovieData(
                    "Avengers: End Game",
                    4,
                    "Action, Adventure, Drama",
                    125,
                    137,
                    R.drawable.movie_avengers,
                    true,
                    13,
                    "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\' actions and restore balance to the universe.",
                    arrayListOf(
                            ActorData(1, "Robert Downey Jr.", R.drawable.movie),
                            ActorData(2, "Chris Evans", R.drawable.movie_2),
                            ActorData(3, "Mark Ruffalo", R.drawable.movie_3),
                            ActorData(4, "Chris Hemsworth", R.drawable.movie_4),
                    )
            ),
            MovieData(
                    "Tenet",
                    4,
                    "Action, Sci-Fi, Thriller",
                    98,
                    98,
                    R.drawable.movie_tenet,
                    true,
                    13,
                    "A secret agent embarks on a dangerous, time-bending mission to prevent the start of World War III.",
                    arrayListOf(
                            ActorData(1, "Robert Downey Jr.", R.drawable.movie),
                            ActorData(2, "Chris Evans", R.drawable.movie_2),
                            ActorData(3, "Mark Ruffalo", R.drawable.movie_3),
                            ActorData(4, "Chris Hemsworth", R.drawable.movie_4),
                    )
            ),
            MovieData(
                    "Black Widow",
                    3,
                    "Action, Adventure, Sci-Fi",
                    38,
                    94,
                    R.drawable.movie_black_widow,
                    false,
                    13,
                    "At birth the Black Widow (aka Natasha Romanova) is given to the KGB, which grooms her to become its ultimate operative. When the U.S.S.R. breaks up, the government tries to kill her as the action moves to present-day New York, where she is a freelance operative.",
                    arrayListOf(
                            ActorData(1, "Robert Downey Jr.", R.drawable.movie),
                            ActorData(2, "Chris Evans", R.drawable.movie_2),
                            ActorData(3, "Mark Ruffalo", R.drawable.movie_3),
                            ActorData(4, "Chris Hemsworth", R.drawable.movie_4),
                    )
            ),
            MovieData(
                    "Wonder Woman 1984",
                    4,
                    "Action, Adventure, Fantasy",
                    74,
                    120,
                    R.drawable.movie_wonder_women,
                    false,
                    13,
                    "Wonder Woman squares off against Maxwell Lord and the Cheetah, a villainess who possesses superhuman strength and agility.",
                    arrayListOf(
                            ActorData(1, "Robert Downey Jr.", R.drawable.movie),
                            ActorData(2, "Chris Evans", R.drawable.movie_2),
                            ActorData(3, "Mark Ruffalo", R.drawable.movie_3),
                            ActorData(4, "Chris Hemsworth", R.drawable.movie_4),
                    )
            )
    )
}