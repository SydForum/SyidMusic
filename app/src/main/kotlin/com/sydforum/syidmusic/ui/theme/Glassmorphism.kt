package com.sydforum.syidmusic.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.blur

fun Modifier.liquidGlassEffect(
    cornerRadius: Dp = 24.dp,
    blurRadius: Dp = 16.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.15f),
    borderColor: Color = Color.White.copy(alpha = 0.2f)
): Modifier = this
    .clip(RoundedCornerShape(cornerRadius))
    .background(backgroundColor)
    .border(
        width = 1.dp,
        color = borderColor,
        shape = RoundedCornerShape(cornerRadius)
    )
    .blur(radius = blurRadius)
