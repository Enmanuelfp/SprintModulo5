package cl.bootcamp.sprintmodulo5.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import cl.bootcamp.sprintmodulo5.model.CartItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStore(private val context: Context) {
    // Definimos una clave para almacenar la lista en formato JSON
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("ListCart")
        val LIST_CART = stringPreferencesKey("list_Cart")
    }


    suspend fun saveListCart(list: List<CartItem>) {
        context.dataStore.edit { preferences ->
            val json = Gson().toJson(list)
            preferences[LIST_CART] = json
        }
    }


    val getListCart: Flow<List<CartItem>> = context.dataStore.data
        .map { preferences ->
            val cartJson = preferences[LIST_CART] ?: "" // Si no existe, devolvemos una cadena vacía
            if (cartJson.isNotEmpty()) {
                // Usamos Gson para deserializar el JSON a una lista de CartItem
                val type = object : TypeToken<List<CartItem>>() {}.type
                Gson().fromJson(cartJson, type)
            } else {
                emptyList()
            }
        }



}

