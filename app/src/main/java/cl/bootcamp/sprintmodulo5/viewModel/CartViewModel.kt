package cl.bootcamp.sprintmodulo5.viewModel

import cl.bootcamp.sprintmodulo5.data.DataStore

fun addCartDataStore(viewModel: ShoesTapViewModel,dataStore: DataStore){
   val datos= viewModel.cartItems
    viewModelScope.launch { dataStore.saveListCart(cartItems) }
}