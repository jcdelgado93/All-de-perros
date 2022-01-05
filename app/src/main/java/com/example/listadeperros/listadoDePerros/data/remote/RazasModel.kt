package com.example.listadeperros.listadoDePerros.data.remote

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RazasModel(
    val message : List<String>
)
