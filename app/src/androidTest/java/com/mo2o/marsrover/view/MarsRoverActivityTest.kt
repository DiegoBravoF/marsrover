package com.mo2o.marsrover.view

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import com.mo2o.marsrover.presentation.MarsRoverPresenter
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
class MarsRoverActivityTest {
    lateinit var presenter: MarsRoverPresenter
    private lateinit var sut: MarsRoverActivity
    @get:Rule
    var activityTestRule: ActivityTestRule<MarsRoverActivity> =
            object : ActivityTestRule<MarsRoverActivity>(MarsRoverActivity::class.java,
                    false,
                    false) {
                override fun beforeActivityLaunched() {
                    super.beforeActivityLaunched()
                    val serviceLocator =
                            InstrumentationRegistry.getTargetContext().applicationContext
                                    as TestApplication
                    serviceLocator.presenter = presenter
                }
            }

    @Before
    fun setUp() {
        presenter = mock()
        val intent = Intent(Intent.ACTION_MAIN)
        sut = activityTestRule.launchActivity(intent)
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(sut)
    }
}