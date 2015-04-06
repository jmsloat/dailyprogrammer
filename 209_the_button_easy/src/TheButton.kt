package com.sloat.dailyprogrammer

import java.io.File

fun main(args: Array<String>) {
    TheButton()
}

class TheButton {

    data class User(val name: String, val time: Float)

    var timePassed = 0.0f

    init{
        val users = readInputFile()
        users.map({it -> println("${it.name} (${calcFlair(it.time)})")})
    }

    fun readInputFile() : List<User> {
        val input = File("infile.txt").readLines()
        return input.map { it -> User(name=it.split(":")[0], time=it.split(":")[1].toFloat()) } sortBy({it.time})
    }

    fun calcFlair(timePressed: Float) : Int {

        val flair = 60 - Math.ceil((timePressed - timePassed).toDouble())
        timePassed = timePressed
        return flair.toInt()
    }
}