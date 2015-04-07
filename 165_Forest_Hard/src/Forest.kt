package com.sloat.dailyprogrammer

import com.sloat.dailyprogrammer

import kotlin
import java.util.Random

fun main(args: Array<String>) {
    Forest()
}

class Forest() {

    val size = 10
    val randomizer = Random()
    var forest = Array(size, {it -> Array<Inhabitant>(size, {it->EmptySpace()})})

    init {
        initForest()
        printForest()
    }


    fun initForest()  {
        fillGridWith(10, "Lumberjack")
        fillGridWith(50, "Tree")
        fillGridWith(2, "Bear")
    }

    fun fillGridWith(nToFill: Int, type: String) {
        for (i in (0..nToFill-1)) {

            var location = getRandomSpace(10)
            while (forest[location.first][location.second] !is EmptySpace) {
                location = getRandomSpace(10)
            }

            when(type) {
                "Lumberjack" -> forest[location.first][location.second] = Lumberjack()
                "Tree" -> forest[location.first][location.second] = Tree()
                "Bear" -> forest[location.first][location.second] = Bear()
                else -> throw IllegalArgumentException()
            }
        }
    }

    fun getRandomSpace(limit: Int) : Pair<Int, Int> {

        val x = randomizer.nextInt(limit)
        val y = randomizer.nextInt(limit)

        return Pair(x,y)
    }

    fun printForest() {
        for(row in forest) {
            for (col in row) {
                print(col.repr)
            }
            println()
        }
    }
}