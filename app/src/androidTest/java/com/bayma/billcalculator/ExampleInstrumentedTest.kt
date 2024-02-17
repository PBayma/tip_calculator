package com.bayma.billcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.text.NumberFormat

@RunWith(AndroidJUnit4::class)
class TipCalculatorTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeLayout()
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("100")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        composeTestRule.onNodeWithText("Tip Amount: \$20.00").assertExists("No node with this text was found.")

    }

    @Test
    fun calculate_round_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeLayout()
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("98")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        composeTestRule.onNodeWithTag("roundUpSwitch").performClick()
        composeTestRule.onNodeWithText("Tip Amount: \$20.00").assertExists("No node with this text was found.")

    }
}