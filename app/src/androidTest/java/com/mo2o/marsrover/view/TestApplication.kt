package com.mo2o.marsrover.view

import android.app.Application
import com.mo2o.marsrover.ServiceLocator
import com.mo2o.marsrover.presentation.MarsRoverPresenter
import com.nhaarman.mockitokotlin2.mock

class TestApplication : Application(), ServiceLocator {
    var presenter: MarsRoverPresenter? = null
    override fun getMarsRoverPresenter() = presenter ?: mock()
}