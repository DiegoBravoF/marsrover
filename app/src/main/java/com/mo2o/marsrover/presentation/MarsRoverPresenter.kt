package com.mo2o.marsrover.presentation

class MarsRoverPresenter {
    var viewMars: MarsRoverView? = null

    fun attach(mainActivity: MarsRoverView) {
        viewMars = mainActivity
    }

    fun commandHasChanged(toString: String) {
        viewMars?.changeStatusButton(toString.isNotEmpty())
    }
}