package com.hfad.translator.view.main

import androidx.lifecycle.LiveData
import com.hfad.translator.model.data.AppState
import com.hfad.translator.utils.parseSearchResults
import com.hfad.translator.viewmodel.BaseViewModel
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainViewModel(private val interactor: MainInteractor) :
    BaseViewModel<AppState>() {


    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor (word, isOnline) }
    }


    private suspend fun startInteractor (word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(parseSearchResults(interactor.getData(word, isOnline)))
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}