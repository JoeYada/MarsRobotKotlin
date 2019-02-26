package com.example.marsrobotkotlin

class Robot(private var currentDirection: Direction,
            private var xPos: Int,
            private var yPos: Int,
            private val currentEdge: Edge) {

    private val commands: MutableList<Command> = mutableListOf()
    private var isLost = false

    fun getCurrentDirection() = currentDirection

    fun setCurrentDirection(direction: Direction) {
        currentDirection = direction
    }

    fun getXPos() = xPos

    fun setXPos(newPos: Int) {
        if (isLost) return

        if (newPos < currentEdge.xFloor || newPos > currentEdge.xCeiling) {
            isLost = true
            return
        }

        xPos = newPos
    }

    fun getYPos() = yPos

    fun setYPos(newPos: Int) {
        if (isLost) return

        if (newPos < currentEdge.yFloor || newPos > currentEdge.yCeiling) {
            isLost = true
            return
        }

        yPos = newPos
    }

    fun executeCommandsAndGetState(): String {
        for (command in commands) {
            command.execute(this)
        }
        val result = "$xPos $yPos ${currentDirection.name[0]}"

        return if (isLost) "$result LOST" else result
    }

    fun addCommand(command: Command) = commands.add(command)


}