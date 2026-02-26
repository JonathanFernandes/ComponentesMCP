package co.allos.apolo.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AllosColorTokens(
    val ambientNeutral80: Color = Color(0xFF1E1E1E),
    val ambientGrayscale10: Color = Color(0xFFFFFFFF),
)

object AllosTheme {
    val colors: AllosColorTokens = AllosColorTokens()

    operator fun invoke(content: @Composable () -> Unit) {
        content()
    }
}
