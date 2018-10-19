package com.mo2o.marsrover.model

class Rover {
    companion object {
        const val NORTH = 'N'
        const val EAST = 'E'
        const val WEST = 'W'
        const val SOUTH = 'S'
        const val CMD_RIGHT = 'R'
        const val CMD_LEFT = 'L'
        const val CMD_FORWARD = 'F'
        const val CMD_BACKWARD = 'B'
    }

    var orientation: Char = NORTH
    var x = 5
    var y = 5
    var obstacles: List<Obstacle> = emptyList()

    fun receiveCommands(commands: String) {
        for (command in commands) {
            when (command) {
                CMD_RIGHT -> turnRight()
                CMD_LEFT -> turnLeft()
                else -> moveForward()
            }
        }
    }

    private fun moveForward() {
        var futureY = y
        var futureX = x
        when (orientation) {
            NORTH -> futureY++
            EAST -> futureX++
            SOUTH -> futureY--
            else -> futureX--
        }
        if (!checkThereIsAnObstacle(x = futureX, y = futureY)) {
            y = futureY
            x = futureX
        }
    }

    private fun checkThereIsAnObstacle(x: Int, y: Int) = obstacles.find { obstacle -> obstacle.x == x && obstacle.y == y } != null


    private fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            else -> SOUTH
        }
    }

    private fun turnRight() {
        orientation = when (orientation) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            else -> NORTH
        }
    }

    override fun toString(): String {
        return "$x,$y,$orientation"
    }
}
