package com.example.rocketkotlin

class U2 : Rocket(120, 18, 29) {
    override fun launch(): Boolean {
        val chanceOfLaunchExplosion = 5 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight))
        return chanceOfLaunchExplosion < Math.random() * 7
    }

    override fun land(): Boolean {
        val chanceOfLaunchExplosion = 8 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight))
        return chanceOfLaunchExplosion < Math.random() * 14
    }
}