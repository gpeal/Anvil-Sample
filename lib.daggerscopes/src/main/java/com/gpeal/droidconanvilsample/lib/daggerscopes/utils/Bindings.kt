package com.gpeal.droidconanvilsample.lib.daggerscopes.utils

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel

/**
 * Use this to get the dagger "Bindings" for your module. Bindings are used if you need to directly interact with a dagger component such as:
 * * an inject function: `inject(MyFragment frag)`
 * * an explicit getter: `fun myClass(): MyClass`
 *
 * Bindings will walk up the Fragment/Activity hierarchy and check for [DaggerComponentOwner] to see if any of its components provide the specified bindings.
 * Most of the time this will "just work" and you don't have to think about it.
 *
 * To inject [@Inject] properties:
 * 1) Add an inject function to YourModuleBindings
 * 2) Make sure your bindings interface is contributed to AppComponent, UserComponent, etc via `@ContributesTo(AppComponent::class)`.
 * 3) Call context.bindings<YourModuleBindings>().inject(this) (Kotlin)
 */
inline fun <reified T : Any> Context.bindings() = _bindings(T::class.java)

/**
 * @see bindings
 */
inline fun <reified T : Any> Fragment.bindings() = _bindings(T::class.java)

inline fun <reified T : Any> AndroidViewModel.bindings() = ((this as? DaggerComponentOwner)?.daggerComponent as? T) ?: getApplication<Application>()._bindings(T::class.java)


/** Use no-arg extension function instead: [Context._bindings] */
@Suppress("FunctionName")
fun <T : Any> Context._bindings(klass: Class<T>): T {
    // search dagger components in the context hierarchy
    return generateSequence(this) { (it as? ContextWrapper)?.baseContext }
        .plus(applicationContext)
        .filterIsInstance<DaggerComponentOwner>()
        .map { it.daggerComponent }
        .flatMap { if (it is Collection<*>) it else listOf(it) }
        .filterIsInstance(klass)
        .firstOrNull()
        ?: error("Unable to find bindings for ${klass.name}")
}

/** Use no-arg extension function instead: [Fragment._bindings] */
fun <T : Any> Fragment._bindings(klass: Class<T>): T {
    // Search dagger components in fragment hierarchy, then fallback to activity and application
    return generateSequence(this, Fragment::getParentFragment)
        .filterIsInstance<DaggerComponentOwner>()
        .map { it.daggerComponent }
        .flatMap { if (it is Collection<*>) it else listOf(it) }
        .filterIsInstance(klass)
        .firstOrNull()
        ?: requireActivity()._bindings(klass)
}