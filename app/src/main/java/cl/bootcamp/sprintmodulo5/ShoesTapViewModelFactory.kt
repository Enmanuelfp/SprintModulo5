package cl.bootcamp.sprintmodulo5

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.bootcamp.sprintmodulo5.data.CartManager
import cl.bootcamp.sprintmodulo5.viewModel.ShoesTapViewModel

class ShoesTapViewModelFactory(
    private val cartManager: CartManager,
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoesTapViewModel::class.java)) {
            return ShoesTapViewModel(cartManager, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}