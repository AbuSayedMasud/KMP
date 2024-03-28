package shell

import org.example.project.ui.HomeScreen
import org.example.project.ui.MarketScreen
import org.example.project.ui.PortfolioScreen
import org.example.project.ui.ProfileScreen
import org.example.project.ui.ServiceScreen
import org.example.project.ui.TradeScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavHostController
import capitakmmdemo.composeapp.generated.resources.Res
import capitakmmdemo.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
@Composable
fun BottomNavGraph(navController: NavHostController) {
    val profilePhoto: Painter = painterResource(Res.drawable.compose_multiplatform)
    val onProfileClick: () -> Unit = {
        // Handle the profile photo click event here
    }
    val showNotificationIcon = remember { mutableStateOf(false) }
    val colorSelectionViewModel = ColorSelectionViewModel()
    val currentRoute = remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }

    NavHost(navController = navController, startDestination = BottomBar.Market.route) {
//        composable(BottomBar.Home.route) {
//            HomeScreen(
//                navController = navController,
//            )
//        }
        composable(BottomBar.Market.route) {
            MarketScreen(
                navController = navController,
            )
        }
        composable(
            route = "${BottomBar.Portfolio.route}/{${BottomBar.Portfolio.ARG_VALUE}}",
        ) { backStackEntry ->
            val value = backStackEntry.arguments?.getString(BottomBar.Portfolio.ARG_VALUE)

            PortfolioScreen(
                colorSelectionViewModel,
                navController = navController,
                queryParameters = value,
            )
        }

        composable(BottomBar.Trade.route) {
            TradeScreen(navController)
        }

        composable(BottomBar.Service.route) {
            ServiceScreen()
        }
        composable(BottomBar.Profile.route) {
            ProfileScreen(
                colorSelectionViewModel = colorSelectionViewModel,
                navController = navController,
            )
        }
    }
}