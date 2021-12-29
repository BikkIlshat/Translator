package com.hfad.translator.repository

import com.hfad.translator.data.DataModel
import com.hfad.translator.datasource.DataSource
import io.reactivex.rxjava3.core.Observable


/**
 * Репозиторий возвращает данные, используя dataSource (локальный или внешний)
 */
class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
