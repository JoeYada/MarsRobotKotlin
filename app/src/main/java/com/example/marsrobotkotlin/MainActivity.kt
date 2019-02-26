package com.example.marsrobotkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalStateException
import java.lang.UnsupportedOperationException

class MainActivity : AppCompatActivity() {

    private lateinit var planetEngine: PlanetEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetGridSize.setOnClickListener {
            planetEngine = PlanetEngine(etGridXMax.text.toString().toInt(), etGridYMax.text.toString().toInt())
        }

        btnGetFinalState.setOnClickListener {
            if (::planetEngine.isInitialized) {
                val initialPosition = etInitialPosition.text.toString()
                planetEngine.initialiseRobot(
                    initialPosition[0].toString().toInt(), initialPosition[1].toString().toInt(),
                    getDirectionFromString(initialPosition[2])
                )
                tvResult.text = planetEngine.processCommandsAndGetFinalState(etCommands.text.toString())
            } else throw IllegalStateException("Initialise the Planet before performing any actions")
        }
    }

    private fun getDirectionFromString(input: Char): Direction {
        return when (input) {
            'N' -> Direction.NORTH
            'S' -> Direction.SOUTH
            'E' -> Direction.EAST
            'W' -> Direction.WEST
            else -> throw UnsupportedOperationException("Please enter a valid direction")
        }
    }
}
