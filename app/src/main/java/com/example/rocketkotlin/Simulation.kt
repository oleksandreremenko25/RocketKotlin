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
            var fullU: Rocket = U1()

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
            var fullU: Rocket = U2()

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

    fun runSimulation(contextThis: Context, typeRocket: String, arrayListFull_1: List<Rocket>, arrayListFull_2: List<Rocket>): String {
        var numberAllRocket: Int = 0
        val arrayListFull_1_2 = arrayListFull_1 + arrayListFull_2
        var z: Int = 0
        val costOneRocket: Int;

        while (z < arrayListFull_1_2.size) {
            if (arrayListFull_1_2[z].land() || arrayListFull_1_2[z].launch()) {
                z++;
            }
            numberAllRocket++
        }

        if (typeRocket == "U1") {
            val u1: U1 = U1()
            costOneRocket = u1.rocketCost;
        } else {
            val u2: U2 = U2()
            costOneRocket = u2.rocketCost;
        }

        val context: Context = contextThis
        val textAnswerFirstPart: String = context.getString(R.string.textAnswerFirstPart);
        val textAnswerSecondPart: String = context.getString(R.string.textAnswerSecondPart)
        val textAnswerThirddPart: String = context.getString(R.string.textAnswerThirddPart)

        return textAnswerFirstPart + " " + numberAllRocket + " " + textAnswerSecondPart + " " + numberAllRocket * costOneRocket + " " + textAnswerThirddPart;
    }
}