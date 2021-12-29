package com.hfad.translator.repository

import io.reactivex.rxjava3.core.Observable


/***
 * Репозиторий представляет собой слой получения и хранения данных, которые он передаёт Interactor
 */
interface Repository<T> {

    fun getData(word: String): Observable<T>
}