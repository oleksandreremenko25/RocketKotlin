package com.example.rocketkotlin

class U1 : Rocket(100, 10, 18) {
    override fun launch(): Boolean {
        val chanceOfLaunchExplosion = 5 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight))
        return chanceOfLaunchExplosion < Math.random() * 9
    }

    override fun land(): Boolean {
        val chanceOfLaunchExplosion = 1 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight))
        return chanceOfLaunchExplosion < Math.random() * 5
    }
}