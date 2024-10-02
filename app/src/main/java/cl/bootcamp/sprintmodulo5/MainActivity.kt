package cl.bootcamp.sprintmodulo5

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import cl.bootcamp.sprintmodulo5.data.CartManager
import cl.bootcamp.sprintmodulo5.navigate.NavManager
import cl.bootcamp.sprintmodulo5.ui.theme.SprintModulo5Theme
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

class MainActivity : ComponentActivity() {
    private lateinit var shoesTapViewModel: ShoesTapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val cartManager = CartManager(this.applicationContext)
        val factory = ShoesTapViewModelFactory(cartManager, application)
        shoesTapViewModel = ViewModelProvider(this, factory).get(ShoesTapViewModel::class.java)


        setContent {
            SprintModulo5Theme {
                NavManager(viewModel = shoesTapViewModel)
            }
        }
    }
}

