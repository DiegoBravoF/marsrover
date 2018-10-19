package com.mo2o.marsrover

import com.mo2o.marsrover.model.Obstacle
import com.mo2o.marsrover.model.Rover
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class RoverTest {
    private lateinit var sut: Rover
    @Before
    fun setUp() {
        sut = Rover()
    }

    @After
    fun tearDown() {
    }


    @Test
    fun sutIsNotNull() {
        assertNotNull(sut)
    }

    @Test
    fun orientationInitialIsNorth() {
        assertEquals('N', sut.orientation)
    }

    @Test
    fun initialPositionIsFiveFive() {
        assertEquals(5, sut.x)
        assertEquals(5, sut.y)
    }

    @Test
    fun moveForwardCancelWhenObstacleAppears() {
        sut.obstacles = listOf(Obstacle(x = 5, y = 6))

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(5, sut.y)
        assertEquals(5, sut.x)
    }

    @Test
    fun testTurnRightLookEast() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_RIGHT))

        assertEquals('E', sut.orientation)
    }

    @Test
    fun turnRightTwoTimesLooksSouth() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_RIGHT, Rover.CMD_RIGHT))

        assertEquals('S', sut.orientation)
    }

    @Test
    fun turnRightThreeTimesLooksWest() {
        val commands = generateCommands(Rover.CMD_RIGHT, Rover.CMD_RIGHT, Rover.CMD_RIGHT)
        sut.receiveCommands(commands = commands)

        assertEquals('W', sut.orientation)
    }

    private fun generateCommands(vararg command: Char): String = command.joinToString("")

    @Test
    fun turnRightFourTimesLooksNorth() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_RIGHT, Rover.CMD_RIGHT, Rover.CMD_RIGHT, Rover.CMD_RIGHT))

        assertEquals('N', sut.orientation)
    }

    @Test
    fun turnLeftLooksWest() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_LEFT))

        assertEquals('W', sut.orientation)
    }


    @Test
    fun turnLeftTwoTimesLooksSouth() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_LEFT, Rover.CMD_LEFT))

        assertEquals('S', sut.orientation)
    }

    @Test
    fun turnLeftThreeTimesLooksEast() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_LEFT, Rover.CMD_LEFT, Rover.CMD_LEFT))

        assertEquals(Rover.EAST, sut.orientation)
    }

    @Test
    fun turnLeftFourTimesLooksNorth() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_LEFT, Rover.CMD_LEFT, Rover.CMD_LEFT, Rover.CMD_LEFT))

        assertEquals('N', sut.orientation)
    }

    @Test
    fun forwardOrientationNorthIncreaseY() {
        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(6, sut.y)
    }

    @Test
    fun differentPositionForwardOrientationNorthIncreaseY() {
        sut.y = 8

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(9, sut.y)
    }

    @Test
    fun forwardOrientationEastIncreaseX() {
        sut.orientation = Rover.EAST

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(6, sut.x)
    }

    @Test
    fun differentPositionForwardOrientationEastIncreaseX() {
        sut.orientation = Rover.EAST
        sut.x = 8

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(9, sut.x)
    }

    @Test
    fun forwardOrientationSouthDecreaseY() {
        sut.orientation = Rover.SOUTH

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(4, sut.y)
    }

    @Test
    fun differentPositionForwardOrientationSouthDecreaseY() {
        sut.orientation = Rover.SOUTH
        sut.y = 8

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(7, sut.y)
    }

    @Test
    fun forwardOrientationWestDecreaseX() {
        sut.orientation = Rover.WEST

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(4, sut.x)
    }

    @Test
    fun differentPositionForwardOrientationWestDecreaseX() {
        sut.orientation = Rover.WEST
        sut.x = 9

        sut.receiveCommands(commands = generateCommands(Rover.CMD_FORWARD))

        assertEquals(8, sut.x)
    }

    @Test
    fun toStringReturnsCurrentPosition() {
        val returnString = "5,5,N"

        assertEquals(returnString, sut.toString())
    }

    @Test
    fun moveToStringReturnsCurrentPosition() {
        val returnString = "6,5,E"

        sut.x = 6
        sut.orientation = 'E'

        assertEquals(returnString, sut.toString())
    }
}