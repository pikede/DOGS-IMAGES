package com.example.dogs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogs.models.Dogs
import com.example.dogs.service.DogApi
import com.example.dogs.service.DogService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {
    private val api: DogApi = DogService.api
    private val _dogs = MutableLiveData<Dogs>()
    val dogs: LiveData<Dogs> get() = _dogs

    fun getDogList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = api.getListOfDogImages()
                if (response.isSuccessful) {
                    // show dog list
                    response.body()?.let {
                        Log.d("**logged", "getting data ${it.message}")
                        _dogs.postValue(it)
                    }
                } else {
                    Log.d("**logged", "error fetching response ")
                    // handle error response

                }
            } catch (e: Exception) {
                Log.e("**logged", e.message ?: e.toString())
            }
        }
    }
}