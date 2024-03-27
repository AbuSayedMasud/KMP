import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import capitakmmdemo.composeapp.generated.resources.Res
import capitakmmdemo.composeapp.generated.resources.compose_multiplatform
import com.matkovivan.nav_cupcake.ui.theme.CapitaTheme
import shell.ColorSelectionViewModel
import shell.MainScreenBottomBar

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    CapitaTheme {
        val colorSelectionViewModel = ColorSelectionViewModel()
        MainScreenBottomBar(colorSelectionViewModel)
    }
}