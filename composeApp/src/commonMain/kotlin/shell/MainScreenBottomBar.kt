package shell

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreenBottomBar(colorSelectionViewModel: ColorSelectionViewModel) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        bottomBar(navController = navController)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.6.dp)
                .background(if (isSystemInDarkTheme())Color.White.copy(alpha = 0.2f) else Color.Black.copy(alpha = 0.2f)), // Adjust the alpha value as desired
        )
    }) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun bottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBar.Home,
        BottomBar.Market,
        BottomBar.Trade,
        BottomBar.Service,
        BottomBar.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = if (isSystemInDarkTheme()) Color(0xFF283138) else Color.White,
        elevation = if (!isSystemInDarkTheme()) 8.dp else 0.dp,
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    val isDarkTheme = isSystemInDarkTheme()
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val unselectedIconTint = if (!selected) LocalContentColor.current.copy(alpha = 1f) else LocalContentColor.current

    BottomNavigationItem(
        icon = {
            val modifier = if (selected) {
                Modifier.size(26.dp)
            } else {
                Modifier.size(24.dp).alpha(0.8f)
            }
            Icon(
                imageVector = screen.lightIcon,
                contentDescription = "Navigation Icon",
                modifier = modifier,
                tint = if (selected) Color(0xFF978c21) else LocalContentColor.current.copy(alpha = 0.6f)
            )
        },
        selected = selected,
        label = { Text(screen.route) },
        modifier = if (selected) {
            Modifier
        } else {
            Modifier.clickable { navController.navigate(screen.route) }
        },
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().route.toString())
                launchSingleTop = true
            }
        },
        unselectedContentColor = if (isDarkTheme) Color.White.copy(alpha = ContentAlpha.disabled) else Color.Black.copy(alpha = ContentAlpha.disabled),
    )
}
