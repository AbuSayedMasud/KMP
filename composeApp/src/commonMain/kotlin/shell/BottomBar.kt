package shell

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import capitakmmdemo.composeapp.generated.resources.Res
import capitakmmdemo.composeapp.generated.resources.ab_bank
import org.jetbrains.compose.resources.DrawableResource

sealed class BottomBar(
    val route: String,
    val lightIcon: ImageVector,
) {
    data object Home : BottomBar(
        route = "Home",
        lightIcon = Icons.Default.Home,

    )
    data object Market : BottomBar(
        route = "Market",
        lightIcon = Icons.Default.Home,

    )
    data object Portfolio : BottomBar(
        route = "Portfolio",
        lightIcon = Icons.Default.Home,

    ) {
        const val ARG_VALUE = "value"
    }

    data object Service : BottomBar(
        route = "Service",
        lightIcon = Icons.Default.Home,
    )
    data object Trade : BottomBar(
        route = "Trade",
        lightIcon = Icons.Default.Home,

    )
    data object Profile : BottomBar(
        route = "Profile",
        lightIcon = Icons.Default.Home,
    )
}
