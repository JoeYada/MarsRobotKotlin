package com.example.marsrobotkotlin

sealed class Command {
    abstract fun execute(robot: Robot): Robot

    object TurnLeft : Command() {
        override fun execute(robot: Robot): Robot {
            when(robot.getCurrentDirection()) {
                Direction.NORTH -> robot.setCurrentDirection(Direction.WEST)
                Direction.SOUTH -> robot.setCurrentDirection(Direction.EAST)
                Direction.EAST -> robot.setCurrentDirection(Direction.NORTH)
                Direction.WEST -> robot.setCurrentDirection(Direction.SOUTH)
            }
            return robot
        }
    }

    object TurnRight : Command() {
        override fun execute(robot: Robot): Robot {
            when(robot.getCurrentDirection()) {
                Direction.NORTH -> robot.setCurrentDirection(Direction.EAST)
                Direction.SOUTH -> robot.setCurrentDirection(Direction.WEST)
                Direction.EAST -> robot.setCurrentDirection(Direction.SOUTH)
                Direction.WEST -> robot.setCurrentDirection(Direction.NORTH)
            }
            return robot
        }

    }

    object GoForward: Command() {
        override fun execute(robot: Robot): Robot {
            when(robot.getCurrentDirection()) {
                Direction.NORTH -> robot.setYPos(robot.getYPos() + 1)
                Direction.SOUTH -> robot.setYPos(robot.getYPos() - 1)
                Direction.EAST -> robot.setXPos(robot.getXPos() + 1)
                Direction.WEST -> robot.setXPos(robot.getXPos() - 1)
            }
            return robot
        }

    }

}