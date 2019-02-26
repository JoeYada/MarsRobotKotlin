package com.example.marsrobotkotlin

import java.lang.IllegalStateException

class PlanetEngine {

    private lateinit var robot: Robot

    fun initialiseRobot(startX: Int, startY: Int, direction: Direction) {
        robot = Robot(currentDirection = direction,
            xPos = startX,
            yPos = startY)
    }

    fun processCommandsAndGetFinalState(input: String): String {
        if (::robot.isInitialized) {
            input.forEach {
                when(it) {
                    'L' -> robot.addCommand(Command.TurnLeft)
                    'R' -> robot.addCommand(Command.TurnRight)
                    'F' -> robot.addCommand(Command.GoForward)
                }
            }
            return robot.executeCommandsAndGetState()
        }
        throw IllegalStateException("Please initialise robot before using it")
    }
}