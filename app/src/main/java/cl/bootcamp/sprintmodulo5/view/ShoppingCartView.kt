package cl.bootcamp.sprintmodulo5.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.sprintmodulo5.data.DataStore
import cl.bootcamp.sprintmodulo5.model.CartItem
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(
    shoppingCart: State<List<CartItem>>,
    navController: NavController,
    viewModel: ShoesTapViewModel
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Carrito",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color(0xFFFF6F61)
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("home")
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            CartItemCount(viewModel,shoppingCart)
        }
    }
}

@Composable
fun CartItemCount(viewModel: ShoesTapViewModel, shoppingCart: State<List<CartItem>>) {
    // Accedemos a la lista de items del carrito desde el shoppingCart
    val itemsLista = shoppingCart.value


    // Mostramos el número de elementos en el carrito, obtenidos desde viewModel
    Text(
        text = "Items en el carrito (ViewModel): ${viewModel.cartItems.size}",
        modifier = Modifier.padding(16.dp)
    )

    // Mostramos el número de elementos en el carrito obtenidos desde el DataStore
    Text(
        text = "Items en el carrito (DataStore): ${itemsLista.size}",
        modifier = Modifier.padding(16.dp)
    )
}



