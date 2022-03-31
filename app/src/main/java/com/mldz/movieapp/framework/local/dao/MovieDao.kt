package com.mldz.movieapp.framework.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mldz.movieapp.framework.local.entity.MovieEntity


@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY id DESC")
    suspend fun getMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id ORDER BY id DESC")
    suspend fun getMovie(id: Long): MovieEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity>)
}