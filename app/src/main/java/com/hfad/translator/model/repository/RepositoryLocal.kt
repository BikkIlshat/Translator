package com.hfad.translator.model.repository

import com.hfad.translator.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
}
