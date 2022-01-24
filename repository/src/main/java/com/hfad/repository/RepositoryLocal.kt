package com.hfad.repository

import com.hfad.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}
