package com.hfad.translator.model.datasource

import com.hfad.translator.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
}