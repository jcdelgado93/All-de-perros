package com.example.listadeperros.listadoDePerros.data.remote

import retrofit2.http.GET

interface ApiRazas {

    @GET("list")
    suspend fun obtenerRazas() : RazasModel
}