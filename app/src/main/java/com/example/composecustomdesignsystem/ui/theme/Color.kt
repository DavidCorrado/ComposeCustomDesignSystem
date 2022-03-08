package com.example.composecustomdesignsystem.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Green = Color(0xFF00FF00)

val Colors.isOnPrimary: Boolean
    @Composable
    get() = MaterialTheme.colors.onPrimary == LocalContentColor.current
val Colors.GreenOrWhite: Color
    @Composable
    get() = if(isLight && !isOnPrimary) Green else Color.White