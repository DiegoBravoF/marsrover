package com.mo2o.marsrover.presentation

interface MarsRoverView {
    fun printStatus(status: String)
    fun clearCommands()
    fun changeStatusButton(enable: Boolean)
}