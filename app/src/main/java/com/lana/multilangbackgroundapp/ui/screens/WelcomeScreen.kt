package com.lana.multilangbackgroundapp.ui.screens

import android.widget.FrameLayout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.lana.multilangbackgroundapp.R
import com.lana.multilangbackgroundapp.ui.theme.MultiLangBackgroundAppTheme
import com.lana.multilangbackgroundapp.ui.utils.ResponsiveScalars
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth


@Composable
fun WelcomeScreen(
    onBack: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo Nine-Patch nativo
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx -> FrameLayout(ctx).apply { setBackgroundResource(R.drawable.background_fixed) } }
        )

        BoxWithConstraints(Modifier.fillMaxSize()) {
            val isLandscape = maxWidth > maxHeight
            val scalars = ResponsiveScalars(maxWidth, maxHeight, isLandscape)

            val baseTitle = scalars.titleSp
            val titleSp = (baseTitle.value * 1.2f).sp
            val lineHeightSp = (titleSp.value * 1.15f).sp

            // Título
            Text(
                text = stringResource(id = R.string.welcome_app_message),
                color = Color.White,
                fontSize = titleSp,
                lineHeight = lineHeightSp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 2,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxSize()
                    .padding(top = scalars.titleTopPadding, start = 24.dp, end = 24.dp)
            )

            val btnWidth = (scalars.buttonWidth * 0.7f)

            if (scalars.isLandscape) {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = scalars.titleTopPadding, start = 24.dp, end = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.welcome_app_message),
                        color = Color.White,
                        fontSize = titleSp,
                        lineHeight = lineHeightSp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(scalars.titleButtonGap))

                    Button(
                        onClick = onBack,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.White),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .widthIn(min = 120.dp, max = 240.dp)
                            .width(btnWidth)
                            .height(44.dp)
                    ) { Text(text = stringResource(id = R.string.back_button), fontSize = 16.sp) }
                }
            } else {
                Text(
                    text = stringResource(id = R.string.welcome_app_message),
                    color = Color.White,
                    fontSize = titleSp,
                    lineHeight = lineHeightSp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize()
                        .padding(top = scalars.titleTopPadding, start = 24.dp, end = 24.dp)
                )

                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    border = BorderStroke(1.dp, Color.White),
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .widthIn(min = 120.dp, max = 240.dp)
                        .width(btnWidth)
                        .height(44.dp)
                ) { Text(text = stringResource(id = R.string.back_button), fontSize = 16.sp) }
            }

        }
    } // <-- cierra Box raíz
} // <-- cierra la función composable

@Preview(showSystemUi = true, showBackground = true, locale = "es", name = "Portrait ES")
@Composable
fun PreviewWelcomeScreenEs() {
    MultiLangBackgroundAppTheme { WelcomeScreen() }
}

@Preview(
    showSystemUi = true, showBackground = true, locale = "en", name = "Landscape EN",
    device = "spec:parent=Pixel 5,orientation=landscape"
)
@Composable
fun PreviewWelcomeScreenEnLandscape() {
    MultiLangBackgroundAppTheme { WelcomeScreen() }
}

@Preview(showSystemUi = true, showBackground = true, locale = "fr", name = "Portrait FR")
@Composable
fun PreviewWelcomeScreenFr() {
    MultiLangBackgroundAppTheme { WelcomeScreen() }
}

@Preview(
    showSystemUi = true, showBackground = true, locale = "de", name = "Landscape DE",
    device = "spec:parent=Pixel 5,orientation=landscape"
)
@Composable
fun PreviewWelcomeScreenDeLandscape() {
    MultiLangBackgroundAppTheme { WelcomeScreen() }
}

