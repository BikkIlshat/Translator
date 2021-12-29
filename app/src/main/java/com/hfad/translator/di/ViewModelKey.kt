package com.hfad.translator.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * ViewModelKeys помогает сопоставить классы ViewModel,
 *  чтобы ViewModelFactory мог правильно их вводить.
 */

//Ключи, по которому будем хранить нашу ViewModel в фабрике:
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)