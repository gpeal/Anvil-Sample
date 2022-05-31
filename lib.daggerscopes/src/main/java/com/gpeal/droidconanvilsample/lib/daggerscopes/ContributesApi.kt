package com.gpeal.droidconanvilsample.lib.daggerscopes

import kotlin.reflect.KClass

/**
 * Annotate a retrofit interface with this to automatically contribute it to the specified scope.
 * Equivalent to the following declaration in an application module:
 *
 *     @Provides
 *     @Reusable
 *     public fun provideYourApi(retrofit: Retrofit): YourApi = retrofit.create(YourApi::class.java)
 *
 * The generated code created via the :anvilcodegen module.
 */
@Target(AnnotationTarget.CLASS)
annotation class ContributesApi(val scope: KClass<*>)
