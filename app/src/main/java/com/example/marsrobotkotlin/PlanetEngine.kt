package com.example.marsrobotkotlin

import java.lang.IllegalStateException

class PlanetEngine(private val xMax: Int, private val yMax: Int) : Robot.OnRobotLostListener {


    private lateinit var robot: Robot
    private val markedCoordinates = mutableListOf<Pair<Int, Int>>()


    fun initialiseRobot(startX: Int, startY: Int, direction: Direction) {
        robot = Robot(currentDirection = direction,
            xPos = startX,
            yPos = startY,
            currentEdge = Edge(0, xMax, 0, yMax),
            markedCoordinates = markedCoordinates,
            listener = this)
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

    override fun onRobotLost(lostPos: Pair<Int, Int>) {
        markedCoordinates.add(lostPos)
    }
}