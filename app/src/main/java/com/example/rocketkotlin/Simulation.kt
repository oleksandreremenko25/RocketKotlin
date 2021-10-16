package com.example.rocketkotlin

import android.content.Context
import android.content.res.AssetManager
import java.io.File
import java.io.IOException
import java.util.*

class Simulation {
    @Throws(IOException::class)
    fun loadItems(contextThis: Context, itemPhase: String): MutableList<Item> {
        val arrayListItem = mutableListOf<Item>()
        val context: Context = contextThis
        val manegerForAsset: AssetManager = context.assets
        val scanner: Scanner = Scanner(manegerForAsset.open(itemPhase))

        while(scanner.hasNextLine()) {
            val descriptionCargo: String = scanner.nextLine()
            val splitDescriptionCargo: List<String> = descriptionCargo.split("=")
            val item: Item = Item(splitDescriptionCargo[0], Integer.parseInt(splitDescriptionCargo[1]))
            arrayListItem.add(item)
        }

        return arrayListItem
    }

    fun loadU1(itemList: MutableList<Item>): MutableList<Rocket> {
        val listFullU: MutableList<Rocket> = mutableListOf<Rocket>()

        while(itemList.isNotEmpty()) {
            val fullU: Rocket = U1()

            for (i in 0 .. itemList.size) {
                if (i < itemList.size && fullU.canCarry(itemList[i])) {
                    fullU.carry(itemList[i])
                    itemList.removeAt(i)
                }
            }

            listFullU.add(fullU)
        }

        return listFullU;
    }

    fun loadU2(itemList: MutableList<Item>): MutableList<Rocket> {
        val listFullU: MutableList<Rocket> = mutableListOf<Rocket>()

        while(itemList.isNotEmpty()) {
            val fullU: Rocket = U2()

            for (i in 0 .. itemList.size) {
                if (i < itemList.size && fullU.canCarry(itemList[i])) {
                    fullU.carry(itemList[i])
                    itemList.removeAt(i)
                }
            }

            listFullU.add(fullU)
        }

        return listFullU;
    }

    fun runSimulation(contextThis: Context, arrayListFull_1: MutableList<Rocket>, arrayListFull_2: MutableList<Rocket>): String {
        var numberAllRocket: Int = 0
        var allRocketCost: Int = 0
        arrayListFull_1.addAll(arrayListFull_2)
        var z: Int = 0

        while (z < arrayListFull_1.size) {
            val oneRocket: Rocket = arrayListFull_1[z]

            if (oneRocket.land() && oneRocket.launch()) {
                z++;
            }

            allRocketCost = allRocketCost + oneRocket.rocketCost
            numberAllRocket++
        }

        val context: Context = contextThis
        val textAnswerFirstPart: String = context.getString(R.string.textAnswerFirstPart);
        val textAnswerSecondPart: String = context.getString(R.string.textAnswerSecondPart)
        val textAnswerThirddPart: String = context.getString(R.string.textAnswerThirddPart)

        return "$textAnswerFirstPart $numberAllRocket $textAnswerSecondPart $allRocketCost $textAnswerThirddPart";
    }
}