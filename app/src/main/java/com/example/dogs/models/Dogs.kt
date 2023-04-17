package com.example.dogs.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Dogs(
    @SerializedName("message") @Expose val message: List<String?>,
    @SerializedName("status") @Expose val status: String
)
