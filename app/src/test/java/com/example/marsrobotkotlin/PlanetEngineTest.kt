package com.example.marsrobotkotlin

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PlanetEngineTest {

    private lateinit var planetEngine: PlanetEngine

    @Before
    fun setup() {
        planetEngine = PlanetEngine()
    }


    @Test
    fun testNormalInput() {
        planetEngine.initialiseRobot(1, 1, Direction.EAST)
        Assert.assertEquals("1 1 E", planetEngine.processCommandsAndGetFinalState("RFRFRFRF"))
    }
}