package com.hfad.translator.presenter

import io.reactivex.rxjava3.core.Observable


/***
 *  Еще выше от Presenter стоит Interactor. Здесь чистая бизнес-логика
 */
interface Interactor<T> {

    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}