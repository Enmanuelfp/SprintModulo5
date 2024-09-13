package cl.bootcamp.sprintmodulo5.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cl.bootcamp.sprintmodulo5.R
import cl.bootcamp.sprintmodulo5.component.ShoeCard
import cl.bootcamp.sprintmodulo5.component.TitleNameList
import cl.bootcamp.sprintmodulo5.model.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.store_name),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge // Título más destacado
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFFF6F61)) // Color acento para la barra superior
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5)), // Fondo neutro suave
        ) {
            space()
            TitleNameList(title = stringResource(id = R.string.category_shoes))
            space()
            Shoes()
            space()
            TitleNameList(title = stringResource(id = R.string.category_sneakers))
            space()
            Sneaker()
            space()
        }
    }
}

@Composable
fun space() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun TitleNameList(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(color = Color(0xFFFF6F61)), // Título con color acento
        modifier = Modifier.padding(start = 16.dp),
    )
}

@Composable
fun Shoes() {
    val shoes = listOf(
        ProductItem(R.drawable.zapato_rojo1, stringResource(id = R.string.shoe_red_1), null, 23990),
        ProductItem(R.drawable.zapato_marron3, stringResource(id = R.string.shoe_brown_3), null, 28990),
        ProductItem(R.drawable.zapato_negro1, stringResource(id = R.string.shoe_black_1), null, 17990),
        ProductItem(R.drawable.zapato_negro2, stringResource(id = R.string.shoe_black_2), null, 22990),
        ProductItem(R.drawable.zapato_negro3, stringResource(id = R.string.shoe_black_3), null, 26990),
        ProductItem(R.drawable.zapato_marron1, stringResource(id = R.string.shoe_brown_1), null, 32990),
        ProductItem(R.drawable.zapato_marron2, stringResource(id = R.string.shoe_brown_2), null, 42990),
    )

    LazyRow {
        items(shoes) { shoe ->
            ShoeCard(
                img = painterResource(id = shoe.imageResID),
                title = shoe.title,
                description = shoe.contentDescription ?: "",
                price = shoe.price.toString(),
                onClick = { /* Aquí puedes manejar el evento de clic */ }
            )
        }
    }
}

@Composable
fun Sneaker() {
    val sneakers = listOf(
        ProductItem(R.drawable.zapatilla_roja, title = stringResource(id = R.string.sneaker_red), contentDescription = null, 31990),
        ProductItem(R.drawable.zapatilla_colores, title = stringResource(id = R.string.sneaker_multicolor), contentDescription = null, 32990),
        ProductItem(R.drawable.zapatilla_azul1, title = stringResource(id = R.string.sneaker_blue_1), contentDescription = null, 37990),
        ProductItem(R.drawable.zapatilla_azul2, title = stringResource(id = R.string.sneaker_blue_2), contentDescription = null, 35990),
        ProductItem(R.drawable.zapatilla_azul3, title = stringResource(id = R.string.sneaker_blue_3), contentDescription = null, 42990),
        ProductItem(R.drawable.zapatilla_verde1, title = stringResource(id = R.string.sneaker_green_1), contentDescription = null, 62990),
        ProductItem(R.drawable.zapatilla_verde2, title = stringResource(id = R.string.sneaker_green_2), contentDescription = null, 42990),
    )

    LazyRow {
        items(sneakers) { shoe ->
            ShoeCard(
                img = painterResource(id = shoe.imageResID),
                title = shoe.title,
                description = shoe.contentDescription ?: "",  // Manejamos el valor nulo
                price = shoe.price.toString(),
                onClick = { /* Aquí puedes manejar el evento de clic */ }
            )
        }
    }
}


