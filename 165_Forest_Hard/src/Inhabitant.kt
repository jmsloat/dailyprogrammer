package com.sloat.dailyprogrammer

public abstract class Inhabitant() {
    abstract val type : String
    abstract val repr : Char
}

public class Lumberjack : Inhabitant() {
    public override val type: String =
            "Lumberjack"
    override val repr = 'L'
}

public class Tree : Inhabitant() {
    override val type = "Tree"
    override val repr = 't'
}

public class EmptySpace : Inhabitant() {
    override val type = "Nothing"
    override val repr = '.'
}

public class Bear : Inhabitant() {
    override val type = "Bear"
    override val repr = 'B'
}