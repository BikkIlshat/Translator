package com.hfad.repository


/***
 * Репозиторий представляет собой слой получения и хранения данных, которые он передаёт Interactor
 */

interface Repository<T> {

    suspend fun getData(word: String): T
}
