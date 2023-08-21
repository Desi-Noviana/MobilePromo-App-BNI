package com.example.mobilepromo

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilepromo.api.ApiService
import com.example.mobilepromo.model.PromoModelItem
import kotlinx.coroutines.launch

class PromoViewModel : ViewModel() {
    private val api: ApiService = ApiService.getInstance()
    var listPromo : List<PromoModelItem?>? by mutableStateOf(listOf())
    var promo : PromoModelItem? = null

    init {
        getListPromo()
    }

    private fun getListPromo(){
        viewModelScope.launch {
            try {
                listPromo = api.getPromos()
            } catch (e: Exception){
                Log.d("error:", e.message.toString())
            }
        }
    }

    fun getDetailPromo(id: Int){
        viewModelScope.launch {
            try {
                promo = listPromo?.first{ it?.id == id}
            } catch (e: Exception){
                Log.d("error:", e.message.toString())
            }
        }
    }
}