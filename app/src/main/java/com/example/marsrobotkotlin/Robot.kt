package com.example.marsrobotkotlin

class Robot(private var currentDirection: Direction,
            private var XPos: Int,
            private var YPos: Int,
            private val commands: List<Command>) {

}