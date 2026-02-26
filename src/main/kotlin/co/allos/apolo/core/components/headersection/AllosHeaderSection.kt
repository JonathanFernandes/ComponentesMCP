package co.allos.apolo.core.components.headersection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import co.allos.apolo.core.components.texts.BodyMedium
import co.allos.apolo.core.components.texts.Heading5
import co.allos.apolo.core.theme.AllosDimensions
import co.allos.apolo.core.theme.AllosTheme

/**
 * Componente de seção de cabeçalho para fluxos com título e subtítulo opcional.
 *
 * Diretrizes aplicadas:
 * - design tokens via [AllosTheme] e [AllosDimensions]
 * - sem valores literais de cor/tamanho
 * - componente stateless
 * - previews para default, variação e edge case
 */
@Composable
fun AllosHeaderSection(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    titleColor: Color = AllosTheme.colors.ambientNeutral80,
    subtitleColor: Color = AllosTheme.colors.ambientNeutral80,
    backgroundColor: Color = AllosTheme.colors.ambientGrayscale10,
) {
    AllosTheme {
        Column(
            modifier =
                modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .padding(
                        horizontal = AllosDimensions.Padding.paddingSm,
                        vertical = AllosDimensions.Padding.paddingXl,
                    ),
            verticalArrangement = Arrangement.spacedBy(AllosDimensions.Gap.gapSm),
        ) {
            Heading5(
                text = title,
                color = titleColor,
            )

            subtitle?.let {
                BodyMedium(
                    text = it,
                    color = subtitleColor,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AllosHeaderSectionPreviewDefault() {
    AllosTheme {
        AllosHeaderSection(
            title = "Criar conta",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AllosHeaderSectionPreviewWithSubtitle() {
    AllosTheme {
        AllosHeaderSection(
            title = "Crie sua senha",
            subtitle = "A sua senha deve ter no mínimo 8 caracteres e combinar letras e números.",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AllosHeaderSectionPreviewEdgeCaseLongContent() {
    AllosTheme {
        AllosHeaderSection(
            title = "Precisamos confirmar sua identidade para continuar com segurança",
            subtitle = "Use um e-mail válido para receber o código de confirmação e concluir o processo sem interrupções.",
        )
    }
}
