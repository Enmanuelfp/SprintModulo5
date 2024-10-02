package cl.bootcamp.sprintmodulo5.model

import java.io.Serializable

data class CartItem(
    val product: ProductItem,
    val cantidad: Int,
    val talla: String
): Serializable
