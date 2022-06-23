package com.mldz.data2.db

import androidx.room.*
import com.mldz.data2.entities.MovieEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {
    @Query("SELECT * FROM movies ORDER BY id DESC")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE id = :id ORDER BY id DESC")
    fun getMovie(id: String): Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity>)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()

    @Update
    suspend fun update(movieEntity: MovieEntity)
}