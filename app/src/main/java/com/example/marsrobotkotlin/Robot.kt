package com.example.marsrobotkotlin

class Robot(private var currentDirection: Direction,
            private var xPos: Int,
            private var yPos: Int) {

    private val commands: MutableList<Command> = mutableListOf()

    fun getCurrentDirection() = currentDirection

    fun setCurrentDirection(direction: Direction) {
        currentDirection = direction
    }

    fun getXPos() = xPos

    fun setXPos(newPos: Int) {
        xPos = newPos
    }

    fun getYPos() = yPos

    fun setYPos(newPos: Int) {
      yPos = newPos
    }

    fun executeCommandsAndGetState(): String {
        for (command in commands) {
            command.execute(this)
        }
        return "$xPos $yPos ${currentDirection.name[0]}"
    }

    fun addCommand(command: Command) = commands.add(command)


}