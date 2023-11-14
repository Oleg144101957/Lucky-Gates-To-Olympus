package app.gameplayer.egypt.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationComponent(){

    val navControl = rememberNavController()

    NavHost(navController = navControl, startDestination = Arrows.WaitingScreen.destination){
        composable(route = Arrows.WaitingScreen.destination){
            WaitingDisplay(navControl)
        }

        composable(route = Arrows.LaunchScreen.destination){
            LaunchDisplay(navControl)
        }

        composable(route = Arrows.PlayScreen.destination){
            PlayDisplay(navControl)
        }

        composable(route = Arrows.RulesScreen.destination){
            RulesDisplay()
        }

        composable(route = Arrows.SettingsScreen.destination){
            SettingsDisplay()
        }
    }
}