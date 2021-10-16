package com.example.rocketkotlin

open class Rocket(val rocketCost: Int, var currentWeight: Int, val maxWeight: Int) : SpaceShip {
    var emptyWeight: Int = 0

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        return (maxWeight >= (item.weight + currentWeight))
    }

    override fun carry(item: Item): Int {
        currentWeight = currentWeight + item.weight
        return currentWeight
    }

    init {
        emptyWeight = currentWeight
    }
}