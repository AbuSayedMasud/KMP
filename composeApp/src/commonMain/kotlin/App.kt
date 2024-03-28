import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.runtime.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.matkovivan.nav_cupcake.ui.theme.CapitaTheme
import shell.ColorSelectionViewModel
import shell.MainScreenBottomBar

@Composable
@Preview
fun App() {
    CapitaTheme {
        val colorSelectionViewModel = ColorSelectionViewModel()
        MainScreenBottomBar(colorSelectionViewModel)
    }
}