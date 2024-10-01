package cl.bootcamp.sprintmodulo5.view

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionScreen(navController: NavController,
                      viewModel: ShoesTapViewModel,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = viewModel.selecItem.value?.let { stringResource(it.title) }?:"",
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
            image(viewModel)
            Descripcion(viewModel)
            MultiBtn { }
            Precio(viewModel)
            Boton(viewModel,navController)
        }
    }
}

@Composable
fun image(viewModel: ShoesTapViewModel) {
    viewModel.selecItem.value?.let { painterResource(id = it.imageResID) }?.let {
        Image(
        painter = it,
        contentDescription = null,
    )
    }
}

@Composable
fun Descripcion(description: ShoesTapViewModel) {
    Text(
        text = description.selecItem.value?.contentDescription?.let { stringResource(it) }?:"",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}


@Composable
fun Precio(price: ShoesTapViewModel) {
    Text(
        text = price.selecItem.value?.price.toString(),
        fontWeight = FontWeight.Black,
        fontSize = 25.sp

    )
}

@Composable
fun Boton(viewModel: ShoesTapViewModel, navController: NavController) {
    OutlinedButton(onClick = {
        navController.navigate("cart")
        val talla = viewModel.talla
        viewModel.selecItem.value?.let { viewModel.addToCart(it, cantidad = 1, talla = talla.toString())
        }
    }) {
        Text(
            text = "Agregar al carrito"
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiBtn(onTallaChange: (String) -> Unit) {
    val talla = remember { mutableStateListOf<Int>() }
    val tallaOptions =
        //listOf(stringResource(id = R.string.sexo), stringResource(id = R.string.sexo2))
        listOf("30", "25", "40")

    MultiChoiceSegmentedButtonRow {
        tallaOptions.forEachIndexed { posicion, label ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = posicion,
                    count = 1
                ),
                modifier = Modifier.padding(horizontal = 5.dp),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = Color(0xFFFF6F61),
                    inactiveContainerColor = Color.Transparent,
                    activeContentColor = Color.hsl(210f, 0.1f, 0.9f),
                    inactiveContentColor = Color.hsl(0f, 0f, 0f)

                ),

                onCheckedChange = {
                    if (talla.isEmpty()) {
                        talla.add(posicion)
                        onTallaChange(tallaOptions[posicion]) // Actualiza el ViewModel
                    } else {
                        if (posicion in talla) {
                            talla.remove(posicion)
                            onTallaChange("") // Si se deselecciona, limpiamos el valor en el ViewModel
                        } else {
                            talla.clear()
                            talla.add(posicion)
                            onTallaChange(tallaOptions[posicion]) // Actualiza el ViewModel
                        }
                    }
                },
                checked = posicion in talla
            ) {
                Text(label)
            }
        }
    }
}
