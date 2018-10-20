package com.mo2o.marsrover

import android.app.Application
import com.mo2o.marsrover.presentation.MarsRoverPresenter

open class RoverApplication : Application(), ServiceLocator {

    override fun getMarsRoverPresenter() = MarsRoverPresenter()
}