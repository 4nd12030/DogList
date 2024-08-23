package com.cursokotlin.doglist.responseApi

import com.google.gson.annotations.SerializedName


//Modelo de datos de la respuesta que recibiremos de la Api
data class DogsResponse(
    @SerializedName("status") var status: String,
    @SerializedName("message") var messge: List<String>
)
