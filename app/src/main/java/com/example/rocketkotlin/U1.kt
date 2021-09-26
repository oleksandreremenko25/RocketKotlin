package com.example.rocketkotlin

class U1 : Rocket(100, 10, 18) {
    fun launch(item: Item): Boolean {
        val chanceOfLaunchExplosion: Int =  5 * (item.weight / liftingWeight)

        return (chanceOfLaunchExplosion > 0)
    }

    fun land(item: Item): Boolean {
        val chanceOfLaunchExplosion: Int = 1 * (item.weight / liftingWeight)

        return (chanceOfLaunchExplosion > 0)
    }
}