package com.mldz.data2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mldz.data2.entities.MovieEntity


@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}