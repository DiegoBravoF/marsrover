package com.mo2o.marsrover

import com.mo2o.marsrover.presentation.MarsRoverPresenter
import com.mo2o.marsrover.presentation.MarsRoverView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class MarsRoverPresenterTest {
    private lateinit var sut: MarsRoverPresenter

    lateinit var marsRoverView: MarsRoverView

    @Before
    fun setUp() {
        sut = MarsRoverPresenter()
        marsRoverView = mock()
        sut.attach(marsRoverView)
    }

    @Test
    fun onCommandIsEmptyDisableButton() {
        sut.commandHasChanged("")
        verify(marsRoverView).changeStatusButton(false)
    }

    @Test
    fun onCommandIsFullEnableButton() {
        sut.commandHasChanged("HOLA")
        verify(marsRoverView).changeStatusButton(true)
    }
}