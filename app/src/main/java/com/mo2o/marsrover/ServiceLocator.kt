package com.mo2o.marsrover

import com.mo2o.marsrover.presentation.MarsRoverPresenter

interface ServiceLocator {
    fun getMarsRoverPresenter(): MarsRoverPresenter
}