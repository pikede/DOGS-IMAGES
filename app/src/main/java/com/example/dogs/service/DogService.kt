package com.example.dogs.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogService {
    companion object {
        const val BASE_URL = "https://dog.ceo/api/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: DogApi = retrofit.create(DogApi::class.java)
    }


}