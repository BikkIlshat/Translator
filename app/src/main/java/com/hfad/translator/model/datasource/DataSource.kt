package com.hfad.translator.model.datasource

import io.reactivex.rxjava3.core.Observable

/**
 * Источник данных для репозитория (Интернет, БД и т. п.)
 */
interface DataSource<T> {

  suspend fun getData(word: String): T
}