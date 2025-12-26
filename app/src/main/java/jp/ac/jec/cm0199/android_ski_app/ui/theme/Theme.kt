package jp.ac.jec.cm0199.android_ski_app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable


private val AppColorScheme = darkColorScheme(
    primary = PrimaryGreen,
    background = Background,
    surface = SubtleGreen,
    onPrimary = TextDark,
    onBackground = TextWhite,
    onSurface = TextWhite,
    secondary = AccentGreen,
    tertiary = PlaceholderText,
)

@Composable
fun AndroidskiappTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}
