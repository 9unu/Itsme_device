package com.project.itsme.presentation.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme

@Composable
fun WearAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = WearAppColorPalette,
        typography = WearAppTypography,
        content = content
    )
}