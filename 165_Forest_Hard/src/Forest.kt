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
        fillGridWith<Lumberjack>(10)
        fillGridWith<Tree>(50)
        fillGridWith<Bear>(2)
    }

    // Pretty sure this kind of code is like 100x slower than just using a "when" statement.
    // But, object creation done via generic at runtime! How fucking cool is that?
    inline fun fillGridWith<reified T : Inhabitant>(nToFill: Int) {
        for (i in (0..nToFill-1)) {

            var location = getRandomSpace(10)
            while (forest[location.first][location.second] !is EmptySpace) {
                location = getRandomSpace(10)
            }

           forest[location.first][location.second] = javaClass<T>().newInstance()

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