package com.sloat.dailyprogrammer

import java.io.File
import java.util
import java.util.ArrayList


fun main(args: Array<String>) {

    AsciiGrid()
}

class AsciiGrid  {

    var grid: Grid = readGrid()

    init {
        printGrid(grid)
    }

    data class Grid(val width: Int = -1, val height: Int = -1, var contents: Array<Array<Char>>)

    fun readGrid() : Grid {

        val lines = File("infile.txt").readLines()

        for(line in lines) {
            println(line)
        }

        val (w, h) = lines.get(0).split(' ')

        val cols = Array(w.toInt(), {it -> '.'})
        val chars = Array(h.toInt(), {it -> cols.copyOf()})

        return Grid(w.toInt(), h.toInt(), chars)
    }

    fun printGrid(g: Grid): Unit {
        g.contents[2].set(3, 'H')

        for(row in g.contents) {
            for(col in row) {
                print(col.toString())
            }
            println("")
        }
    }

}