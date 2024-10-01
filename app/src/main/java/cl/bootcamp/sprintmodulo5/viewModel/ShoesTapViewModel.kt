package cl.bootcamp.sprintmodulo5.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.sprintmodulo5.R
import cl.bootcamp.sprintmodulo5.model.CartItem
import cl.bootcamp.sprintmodulo5.model.ProductItem

class ShoesTapViewModel: ViewModel() {
    val shoes = listOf(
        ProductItem(R.drawable.zapato_rojo1, R.string.shoe_red_1, R.string.desc_shoe_red_1, 23990),
        ProductItem(R.drawable.zapato_marron3, R.string.shoe_brown_3, R.string.desc_shoe_brown_3, 28990),
        ProductItem(R.drawable.zapato_negro1, R.string.shoe_black_1, R.string.desc_shoe_black_1, 17990),
        ProductItem(R.drawable.zapato_negro2, R.string.shoe_black_2, R.string.desc_shoe_black_2, 22990),
        ProductItem(R.drawable.zapato_negro3, R.string.shoe_black_3, R.string.desc_shoe_black_3, 26990),
        ProductItem(R.drawable.zapato_marron1, R.string.shoe_brown_1, R.string.desc_shoe_brown_1, 32990),
        ProductItem(R.drawable.zapato_marron2, R.string.shoe_brown_2, R.string.desc_shoe_brown_2, 42990),
    )

    val sneakers = listOf(
        ProductItem(R.drawable.zapatilla_roja, R.string.sneaker_red, R.string.desc_sneaker_red, 31990),
        ProductItem(R.drawable.zapatilla_colores, R.string.sneaker_multicolor, R.string.desc_sneaker_multicolor, 32990),
        ProductItem(R.drawable.zapatilla_azul1, R.string.sneaker_blue_1, R.string.desc_sneaker_blue_1, 37990),
        ProductItem(R.drawable.zapatilla_azul2, R.string.sneaker_blue_2, R.string.desc_sneaker_blue_2, 35990),
        ProductItem(R.drawable.zapatilla_azul3, R.string.sneaker_blue_3, R.string.desc_sneaker_blue_3, 42990),
        ProductItem(R.drawable.zapatilla_verde1, R.string.sneaker_green_1, R.string.desc_sneaker_green_1, 62990),
        ProductItem(R.drawable.zapatilla_verde2, R.string.sneaker_green_2, R.string.desc_sneaker_green_2, 42990),
    )

    //logica descripcion
    private var _selectedItem = mutableStateOf<ProductItem?>(null)
    var selecItem:MutableState<ProductItem?> = _selectedItem

    fun selecProduct(product: ProductItem){
        _selectedItem.value = product
    }

    private var _talla = mutableStateOf("")
    var talla: MutableState<String> = _talla

    //logica carrito
    private var _cartItems = mutableStateListOf<CartItem>()
    var cartItems: MutableList<CartItem> = _cartItems

    fun addToCart(product: ProductItem,cantidad:Int, talla: String){
        val productExiste = _cartItems.find { it.product == product }
        if (productExiste != null){
            val actualizarItem = productExiste.copy(cantidad = productExiste.cantidad + cantidad)
            _cartItems[_cartItems.indexOf(productExiste)] = actualizarItem
        }else{
            _cartItems.add(CartItem(product,cantidad,talla))
        }
        // Aquí podrías llamar a una función para guardar en DataStore
    }


}

