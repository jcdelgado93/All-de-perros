package com.example.listadeperros.detalleDelPerro.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiFotos {

    @GET("/breed_name/images")
    suspend fun obtenerFotos(
        @Path("breed_name") breedName: List<String>
    ): FotosModel
}