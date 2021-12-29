package com.hfad.translator.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hfad.translator.view.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Модуль послужит источником коллекции ViewModel’ей для фабрики:
 * -  используем этот модуль для создания ViewModel
 *  - предоставляем ключ для каждой новой ViewModel при помощи класса
 */
@Module(includes = [InteractorModule::class])
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    /**
     * метод  говорит Dagger’у: помести эту модель в список (map)
    моделей, используя аннотацию @IntoMap, где в качестве ключа будет класс
    MainViewModel::class
     */

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}
