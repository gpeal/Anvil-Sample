package com.gpeal.droidconanvilsample.lib.daggerscopes.utils

import javax.inject.Scope
import kotlin.reflect.KClass

// This could live in a shared library module.
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleIn(val clazz: KClass<*>)