package com.gpeal.droidconanvilsample.utils

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.ConcurrentHashMap

inline fun <reified T : Any> Fragment.fragmentComponent(crossinline factory: (CoroutineScope, Application) -> T) = lazy {
    ViewModelProvider(this)[DaggerComponentHolderViewModel::class.java].get(factory)
}

class DaggerComponentHolderViewModel(app: Application) : AndroidViewModel(app) {
    val map = ConcurrentHashMap<Class<*>, Any>()

    inline fun <reified T> get(factory: (CoroutineScope, Application) -> T): T {
        return map.getOrPut(T::class.java) { factory(viewModelScope, getApplication()) } as T
    }
}
