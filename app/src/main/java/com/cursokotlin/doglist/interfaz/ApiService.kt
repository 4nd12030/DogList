package com.cursokotlin.doglist.interfaz

import com.cursokotlin.doglist.responseApi.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    //suspend es necesaria cuando queremos que la funcion sea ejecutada cuando utilizamos corrutinas
    suspend fun getDdogsByBreeds(@Url url: String) : Response<DogsResponse>

}