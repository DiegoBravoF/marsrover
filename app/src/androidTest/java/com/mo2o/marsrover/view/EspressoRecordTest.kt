package com.mo2o.marsrover.view


import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.mo2o.marsrover.R
import com.mo2o.marsrover.presentation.MarsRoverPresenter
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class EspressoRecordTest {
    private lateinit var sut: MarsRoverActivity
    var presenter: MarsRoverPresenter? = null
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
        presenter = MarsRoverPresenter()
        val intent = Intent(Intent.ACTION_MAIN)
        sut = activityTestRule.launchActivity(intent)
    }

    @Test
    fun espressoRecordTest() {
        val appCompatEditText = onView(
                allOf(withId(R.id.inputCommad), isDisplayed()))
        appCompatEditText.perform(replaceText("ffrl"), closeSoftKeyboard())

        //pressBack()

        val floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()))
        floatingActionButton.perform(click())

        onView(withId(R.id.textLabel)).check(matches(withText("5,7,N")))
    }
}
