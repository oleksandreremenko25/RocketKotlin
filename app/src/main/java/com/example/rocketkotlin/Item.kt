package com.example.rocketkotlin

class Item(var name: String, var weight: Int) {
    init {
        weight = weight/1000
    }
}