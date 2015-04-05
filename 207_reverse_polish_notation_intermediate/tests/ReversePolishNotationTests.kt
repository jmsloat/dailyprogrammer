package com.sloat.dailyprogrammer

import org.junit.Test as test
import junit.framework.Assert
import com.sloat.dailyprogrammer.ReversePolishNotation

class ReversePolishNotationTests {

    val runner = ReversePolishNotation()

    test fun testCase1() {
        val expr = "0+1"
        val result = runner.ParseExpression(expr)
        Assert.assertEquals(result, 1)
    }

    test fun testCase2() {
        val expr = "20-18"
        val result = runner.ParseExpression(expr)
        Assert.assertEquals(result, 2)
    }

    test fun testCase3() {
        val expr = " 3               x                  1   "
        val result = runner.ParseExpression(expr)
        Assert.assertEquals(3, result)
    }

    test fun testCase4() {
        val expr =  " 100    /                25"
        val result = runner.ParseExpression(expr)
        Assert.assertEquals(4, result)
    }

    test fun testCase5() {
        val expr =  " 10 * 6 x 10 / 100"
        val result = runner.ParseExpression(expr)
        Assert.assertEquals(6, result)
    }


}