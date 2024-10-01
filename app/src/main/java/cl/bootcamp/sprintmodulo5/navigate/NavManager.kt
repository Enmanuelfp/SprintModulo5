package cl.bootcamp.sprintmodulo5.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.sprintmodulo5.view.Cart
import cl.bootcamp.sprintmodulo5.view.DescriptionScreen
import cl.bootcamp.sprintmodulo5.view.MainScreen
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

@Composable
fun NavManager(){
    val navController = rememberNavController()
    val viewModel: ShoesTapViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            MainScreen(navController,viewModel)
        }
        composable("description"){
            DescriptionScreen(navController,viewModel)
        }

        composable("cart") {
            Cart()
        }
    }

}