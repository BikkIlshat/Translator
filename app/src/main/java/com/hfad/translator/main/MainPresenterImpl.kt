package com.hfad.translator.main

import com.hfad.translator.data.AppState
import com.hfad.translator.datasource.DataSourceLocal
import com.hfad.translator.datasource.DataSourceRemote
import com.hfad.translator.presenter.Presenter
import com.hfad.translator.repository.RepositoryImpl
import com.hfad.translator.scheduler.SchedulerProvider
import com.hfad.translator.view.MainView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.observers.DisposableObserver

class MainPresenterImpl<T : AppState, V : MainView>(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImpl(DataSourceRemote()),
        RepositoryImpl(DataSourceLocal())
    ),
    protected val disposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {

    private var currentView: V? = null
    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        if (view == currentView) {
            currentView = null
        }

    }

    override fun getData(word: String, isOnline: Boolean) {
        disposable += interactor.getData(word, isOnline)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
            .subscribeWith(getObserver())
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}