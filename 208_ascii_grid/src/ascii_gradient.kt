package com.sloat.dailyprogrammer

import java.io.File
import java.util
import java.util.ArrayList


public fun main(args: Array<String>) {

    val a = AsciiGrid()
    a.readGrid()
}

class AsciiGrid  {

    data class Grid(width: Int, height: Int, contents: Array<Array<Char>> )


    fun readGrid() {

        val infile = File("infile.txt")
        val lines = infile.readLines()

        for(line in lines) {
            println(line)
        }

        val (w, h) = lines.get(0).split(' ')


       //val grid = Grid(lines.get(0).toCharArray())
    }

}