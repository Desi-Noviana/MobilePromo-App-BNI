package com.example.mobilepromo.api

import com.example.mobilepromo.model.PromoModelItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("promos")
    suspend fun getPromos() : List<PromoModelItem?>?

    companion object {
        var apiService: ApiService? = null

        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://content.digi46.id/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}