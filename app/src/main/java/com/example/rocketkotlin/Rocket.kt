package com.example.rocketkotlin

open class Rocket(val rocketCost: Int, var currentWeight: Int, var maxWeight: Int) : SpaceShip {
    var liftingWeight: Int = maxWeight - currentWeight

    override fun launch(): Boolean {
        return true;
    }

    override fun land(): Boolean {
        return true;
    }

    override fun canCarry(item: Item): Boolean {
        return (maxWeight >= (item.weight + currentWeight))
    }

    override fun carry(item: Item): Int {
        if (canCarry(item)) {
            currentWeight = currentWeight + item.weight
        }

        return currentWeight
    }

}