package com.example.marsrobotkotlin

sealed class Command {
    abstract fun execute(robot: Robot): Robot

    object TurnLeft : Command() {
        override fun execute(robot: Robot): Robot {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    object TurnRight : Command() {
        override fun execute(robot: Robot): Robot {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    object GoForward: Command() {
        override fun execute(robot: Robot): Robot {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

}