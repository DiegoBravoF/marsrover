package com.mo2o.marsrover.presentation

import com.mo2o.marsrover.model.Rover

class MarsRoverPresenter {
    var command: String = ""
    var viewMars: MarsRoverView? = null
    var rover = Rover()
    fun attach(mainActivity: MarsRoverView) {
        viewMars = mainActivity
    }

    fun commandHasChanged(toString: String) {
        command = toString.toUpperCase()
        viewMars?.changeStatusButton(toString.isNotEmpty())
    }

    fun viewReady() {
        viewMars?.changeStatusButton(false)
    }

    fun executeCommand() {
        rover.receiveCommands(command)
        viewMars?.printStatus(rover.toString())
        viewMars?.clearCommands()
    }
}