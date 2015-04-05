package com.sloat.dailyprogrammer

import org.jetbrains.kotlin.utils.printAndReturn
import java.util.regex.Pattern

class ReversePolishNotation {

    val operators= "+-/*".toArrayList()

    public fun ParseExpression(expr: String) : Int {
        val flattened = expr.replace(" ", "").replace("x", "*")

        val firstOp = findFirstOp(flattened)
        val left = flattened.substring(0..firstOp-1)
        val right = flattened.substring(firstOp+1..flattened.length()-1)
        val op = flattened.charAt(firstOp).toString()
        return parseSubExpr(left, right, op)
    }

    fun findFirstOp(expr: String) : Int {

        val reg = Pattern.compile("\\D")
        val matcher = reg.matcher(expr)

        matcher.find()
        try {
            val x = matcher.group()
            return expr.indexOf(x)
        }
        catch(e: Exception) {
            //println(e.printStackTrace(
        }

        return -1
    }


    fun parseSubExpr(left: String, right: String, op: String) : Int {

        var l = 0
        var r = 0
        if ( "(" in left) {
           println("Must parse left sub expr")
        }

        if(")" in right) {
            println("Must parse right sub expr")
        }

        val nextLeftOp = findFirstOp(left)
        if(nextLeftOp != -1) {
            l = ParseExpression(left)
        }
        else {
            l = left.toInt()
        }

        val nextRightOp = findFirstOp(right)
        if(nextRightOp != -1) {
            r = ParseExpression(right)
        }
        else {
            r= right.toInt()
        }

        when(op) {
            "+" -> return l.plus(r)
            "-" -> return l.minus(r)
            "*" -> return l.times(r)
            "/" -> return l.div(r)
            else -> throw IllegalArgumentException()
        }

    }

}

