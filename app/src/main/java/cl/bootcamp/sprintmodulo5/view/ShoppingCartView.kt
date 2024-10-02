package cl.bootcamp.sprintmodulo5.view

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.sprintmodulo5.component.ShoeCardItem
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
                actions = {
                    IconButton({ viewModel.deletCart() }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
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
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumnContent(shoppingCart, viewModel, paddingValues)
            TotalAmountDisplay(viewModel)
        }
    }

}
@Composable
fun LazyColumnContent(
    shoppingCart: State<List<CartItem>>,
    viewModel: ShoesTapViewModel,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        items(shoppingCart.value.size) { index ->
            val cartItem = shoppingCart.value[index]
            val totalItemPrice = cartItem.product.price * cartItem.cantidad
            ShoeCardItem(
                img = painterResource(id = cartItem.product.imageResID),
                title = stringResource(id = cartItem.product.title),
                price = totalItemPrice.toString(),
                cantidad = cartItem.cantidad,
                clickUp = { viewModel.addToCart(cartItem.product, 1, cartItem.talla) },
                clickDown = { viewModel.addToCart(cartItem.product, -1, cartItem.talla) },
                clickDelete = {viewModel.deleteItemFromCart(cartItem.product)}
            )
        }
    }
}

@Composable
fun TotalAmountDisplay(viewModel: ShoesTapViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.background(Color.White)){
            Column ( verticalArrangement = Arrangement.SpaceBetween){ Text(
                text = "Total General: $${viewModel.precioPagar} CLP",
                color = Color.Black,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
                Button(
                    onClick = { viewModel.deletCart() },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFFF6F61))
                ) {
                    Text(text = "Finalizar compra")
                } }

        }

    }
}




