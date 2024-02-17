package com.bayma.billcalculator

import org.junit.Test

import org.junit.Assert.*

class TipCalculatorTest {
    @Test
    fun validateTipResult() {
        val expectedValue = "$20.00"
        val result = calculateTip(100.0, 20.0, false)

        assertEquals(result, expectedValue)
    }

    @Test
    fun validateTipResultRoundedUp() {
        val expectedValue = "$20.00"
        val result = calculateTip(98.0, 20.0, true)

        assertEquals(result, expectedValue)
    }
}