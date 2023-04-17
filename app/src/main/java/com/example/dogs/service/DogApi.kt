package com.example.dogs.service

import com.example.dogs.models.Dogs
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {

    @GET("breeds/image/random/35")
    suspend fun getListOfDogImages(): Response<Dogs>

}