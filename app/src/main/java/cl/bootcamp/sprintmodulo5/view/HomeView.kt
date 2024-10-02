package cl.bootcamp.sprintmodulo5.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.sprintmodulo5.R
import cl.bootcamp.sprintmodulo5.component.ShoeCard
import cl.bootcamp.sprintmodulo5.component.TitleNameList
import cl.bootcamp.sprintmodulo5.component.Space
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController,viewModel: ShoesTapViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.store_name),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFFFF6F61))
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5)),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Space()
            TitleNameList(title = stringResource(id = R.string.category_shoes))
            Space()
            Shoes(navController,viewModel)
            Space()
            TitleNameList(title = stringResource(id = R.string.category_sneakers))
            Space()
            Sneaker(navController,viewModel)
            Space()
        }
    }
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
fun Shoes(navController: NavController,viewModel: ShoesTapViewModel) {

    LazyRow {
        items(viewModel.shoes) { shoe ->
            ShoeCard(
                img = painterResource(id = shoe.imageResID),
                title = stringResource(id =shoe.title ) ,
                description = shoe.contentDescription?.let { stringResource(id = it) },
                price = shoe.price.toString(),
                onClick = { navController.navigate("description")
                viewModel.selecProduct(shoe)}
            )
        }
    }
}

@Composable
fun Sneaker(navController: NavController,viewModel: ShoesTapViewModel) {

    LazyRow {
        items(viewModel.sneakers) { sneaker ->
            ShoeCard(
                img = painterResource(id = sneaker.imageResID),
                title = stringResource(id = sneaker.title) ,
                description = sneaker.contentDescription?.let { stringResource(id = it) },
                price = sneaker.price.toString(),
                onClick = { navController.navigate("description")
                    viewModel.selecProduct(sneaker)}
            )
        }
    }
}


