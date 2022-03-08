package com.example.composecustomdesignsystem.ui.theme

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    val colors = if (MaterialTheme.colors.isOnPrimary) {
        ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colors.onPrimary,
            disabledContentColor = MaterialTheme.colors.onPrimary
                .copy(alpha = ContentAlpha.disabled)
        )
    } else {
        ButtonDefaults.textButtonColors()
    }
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(30.dp),
        colors = colors,
        content = content
    )
}