package com.sloat.dailyprogrammer

import kotlin.List
import java.io.File
import java.util.ArrayList

fun main(args: Array<String>) {
    CullingNumbers()
}

class CullingNumbers {

    init{
        println("starting...")
        val numList = readNumList()
        println(numList.distinct()) // done - high-level language makes this easy
    }

    fun readNumList() : List<Int>{

        val fcontents = File("infile.txt").readLines()[0] // just a single line of text
        val nums = fcontents.split(" ")


        return nums.map { it -> it.toInt() }
    }
}
