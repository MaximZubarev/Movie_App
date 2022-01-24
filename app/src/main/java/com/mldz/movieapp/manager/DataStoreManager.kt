package com.mldz.movieapp.manager

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreManager(private val context: Context) {
    private val Context.dataStore by preferencesDataStore("app_preferences")

    companion object {
        val IMAGE_BASE_URL = stringPreferencesKey("image_base_url")
        val POSTER_SIZE = stringPreferencesKey("poster_size")
    }

    suspend fun saveToDataStore(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun getStringValue(key: Preferences.Key<String>): Flow<String> = context.dataStore.data
        .map { preferences ->
            val uiMode = preferences[key] ?: ""
            uiMode
        }
}