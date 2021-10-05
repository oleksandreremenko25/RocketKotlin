package com.example.rocketkotlin

class Item(val name: String, var weight: Int) {
    init {
        weight = weight/1000
    }
}