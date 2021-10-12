package com.example.rocketkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.io.IOException
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var firstBudgetOption: TextView? = null
    var secondBudgetOption: TextView? = null
    val simulation: Simulation = Simulation()
    var simulation2: Simulation = Simulation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstBudgetOption = findViewById(R.id.firstBudgetOption)
        secondBudgetOption = findViewById(R.id.secondBudgetOption)

        startProgram()
    }

    @Throws(Exception::class)
    fun startProgram() {
        val itemPhase1: MutableList<Item> = simulation.loadItems(this,"phase-1.txt")
        val itemPhase2: MutableList<Item> = simulation.loadItems(this,"phase-2.txt")
        val listFullloadU1: MutableList<Rocket> = simulation.loadU1(itemPhase1)
        val listFullloadU2: MutableList<Rocket> = simulation.loadU1(itemPhase2);

        firstBudgetOption?.setText(simulation.runSimulation(this, listFullloadU1, listFullloadU2));

        val itemPhase3: MutableList<Item> = simulation2.loadItems(this, "phase-1.txt")
        val itemPhase4: MutableList<Item> = simulation2.loadItems(this, "phase-2.txt")
        val listFullloadU3: MutableList<Rocket> = simulation2.loadU1(itemPhase3)
        val listFullloadU4: MutableList<Rocket> = simulation2.loadU2(itemPhase4)

        secondBudgetOption?.setText(simulation2.runSimulation(this,listFullloadU3, listFullloadU4))
    }
}