package com.android.lawyer.model

import androidx.compose.ui.graphics.painter.Painter
import org.w3c.dom.Text

data class LawyerDisplayItem(
    val image: Painter,
    val name: String
)

data class LawSuits(
    val image: Painter,
    val laws: String
)