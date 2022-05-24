package com.gpeal.droidconanvilsample.app

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gpeal.droidconanvilsample.feature.weatherui.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun testDataIsShown(): Unit = launchActivity<MainActivity>().use {
        onView(withId(R.id.message)).check(matches(withText("Forecast=[1, 2, 3, 4, 5]")))
    }
}