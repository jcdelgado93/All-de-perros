package com.example.listadeperros.detalleDelPerro.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FotosModel(
    val message: List<String>
)