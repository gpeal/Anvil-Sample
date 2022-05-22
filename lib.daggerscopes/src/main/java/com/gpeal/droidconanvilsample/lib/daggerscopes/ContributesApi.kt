package com.gpeal.droidconanvilsample.lib.daggerscopes

/**
 * Adds api to the @AppComponent graph. Equivalent to the following declaration in an application module:
 *
 *     @Provides
 *     @Reusable
 *     public fun provideYourApi(retrofit: Retrofit): YourApi = retrofit.create(YourApi::class.java)
 *
 */
@Target(AnnotationTarget.CLASS)
annotation class ContributesApi
