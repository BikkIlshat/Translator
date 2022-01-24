package com.hfad.repository

import com.hfad.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}