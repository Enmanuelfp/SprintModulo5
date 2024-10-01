package cl.bootcamp.sprintmodulo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.sprintmodulo5.navigate.NavManager
import cl.bootcamp.sprintmodulo5.ui.theme.SprintModulo5Theme
import cl.bootcamp.sprintmodulo5.view.MainScreen
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = ShoesTapViewModel()
        setContent {
            SprintModulo5Theme {
                NavManager()
            }
        }
    }
}

