package com.sloat.dailyprogrammer

import java.io.File
import java.util
import java.util.ArrayList

import kotlin.*


fun main(args: Array<String>) {

    AsciiGrid()
}

class AsciiGrid  {

    val inputLines = File("infile.txt").readLines()
    var grid: Grid = readGrid(inputLines.get(0))
    val gradiekkntCharacters = inputLines.get(1).toCharList()

    init {
        printGrid(grid)
        calculateGradient(grid)
    }

    data class Grid(val width: Int = -1, val height: Int = -1, var contents: Array<Array<Char>>)

    fun readGrid(line: String) : Grid {

        val (w, h) = line.split(' ')

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

    fun calculateGradient(g: Grid) {
        print("Going...")
    }

}