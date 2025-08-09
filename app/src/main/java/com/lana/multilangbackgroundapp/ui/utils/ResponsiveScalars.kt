package com.lana.multilangbackgroundapp.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Para evitar problemas con Dp en min/max
private fun clampDp(value: Dp, min: Dp, max: Dp): Dp =
    when {
        value < min -> min
        value > max -> max
        else -> value
    }

/**
 * Valores responsivos reutilizables por las dos pantallas.
 * - En portrait mantenemos tu estilo grande.
 * - En landscape hacemos el título compacto (como el mock) y acercamos el botón al título.
 *
 * Nota: tú sigues aplicando multiplicadores al titleSp en cada pantalla
 * (1.4x en MainScreen, 1.2x en Welcome), aquí solo devolvemos la base.
 */
data class LayoutScalars(
    val titleSp: TextUnit,
    val buttonWidth: Dp,
    val titleTopPadding: Dp,
    val titleButtonGap: Dp,
    val isLandscape: Boolean
)

@Composable
fun ResponsiveScalars(
    maxW: Dp,
    maxH: Dp,
    isLandscape: Boolean
): LayoutScalars {
    return if (isLandscape) {
        // Base por lado más corto para que en horizontal no explote el tamaño
        val shortest = if (maxW < maxH) maxW else maxH

        // Título base (compacto). Luego en cada pantalla tú aplicas 1.4x / 1.2x
        val rawTitle = (shortest / 22).value   // más pequeño que /18 para que con 1.4x no sea enorme
        val titleSp: TextUnit = rawTitle.coerceIn(18f, 28f).sp

        // Ancho del botón base (luego tú multiplicas por 0.7f en cada pantalla)
        val bw = (maxW * 0.15f)
        val buttonWidth: Dp = clampDp(bw, 160.dp, 260.dp)

        // Título a ~10% del alto (un poco más arriba) y botón cerca
        val titleTopPadding: Dp = maxH * 0.15f
        val titleButtonGap: Dp = 55.dp

        LayoutScalars(titleSp, buttonWidth, titleTopPadding, titleButtonGap, true)
    } else {
        // Portrait (grande) – base; tú haces Main 1.4x y Welcome 1.2x arriba
        val titleSp: TextUnit = 40.sp
        val buttonWidth: Dp = 200.dp
        val titleTopPadding: Dp = maxH * 0.30f
        val titleButtonGap: Dp = 20.dp

        LayoutScalars(titleSp, buttonWidth, titleTopPadding, titleButtonGap, false)
    }
}
