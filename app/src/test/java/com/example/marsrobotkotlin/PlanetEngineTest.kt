package com.example.marsrobotkotlin

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PlanetEngineTest {

    private lateinit var planetEngine: PlanetEngine

    @Before
    fun setup() {
        planetEngine = PlanetEngine(xMax = 5, yMax = 3)
    }


    @Test
    fun testNormalInput() {
        planetEngine.initialiseRobot(1, 1, Direction.EAST)
        Assert.assertEquals("1 1 E", planetEngine.processCommandsAndGetFinalState("RFRFRFRF"))
    }

    @Test
    fun testLostInput() {
        planetEngine.initialiseRobot(3, 2, Direction.NORTH)
        Assert.assertEquals("3 3 N LOST", planetEngine.processCommandsAndGetFinalState("FRRFLLFFRRFLL"))

    }

    @Test
    fun testLostButRecoverInput() {
        //Given
        testLostInput()
        //When
        planetEngine.initialiseRobot(0, 3, Direction.WEST);
        //Then
        Assert.assertEquals("2 3 S", planetEngine
            .processCommandsAndGetFinalState("LLFFFLFLFL"));
    }
}