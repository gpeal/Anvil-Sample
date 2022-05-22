package com.gpeal.droidconanvilsample.app

import com.gpeal.droidconanvilsample.utils.SingleIn
import com.squareup.anvil.annotations.MergeComponent
import javax.inject.Scope
import kotlin.reflect.KClass

// This could live in a shared library module.
interface AppScope

// This should live in your application module.
@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent