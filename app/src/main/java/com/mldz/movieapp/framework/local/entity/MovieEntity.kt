package com.mldz.movieapp.framework.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val image: String,
    val reviewsCount: Int,
    val rating: Double,
    val isFavorite: Boolean,
    val genres: String,
    val story: String
)