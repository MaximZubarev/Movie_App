package com.mldz.data2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mldz.data2.entities.MovieEntity


@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "movie_app.db"
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}