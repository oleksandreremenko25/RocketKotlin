package com.example.rocketkotlin

class U2 : Rocket(120, 18, 29) {
    fun launch(item: Item): Boolean {
        val chanceOfLaunchExplosion: Int = 4 * (item.weight / liftingWeight)

        return (chanceOfLaunchExplosion > 0)
    }

    fun land(item: Item): Boolean {
        val chanceOfLaunchExplosion: Int =  8 * (item.weight / liftingWeight)

        return (chanceOfLaunchExplosion > 0)
    }
}