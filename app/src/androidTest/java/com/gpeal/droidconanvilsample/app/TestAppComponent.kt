package com.gpeal.droidconanvilsample.app

import com.gpeal.droidconanvilsample.lib.daggerscopes.AppScope
import com.gpeal.droidconanvilsample.lib.daggerscopes.SingleIn
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface TestAppComponent
