package com.example.listadeperros.detalleDelPerro.domain

import com.example.listadeperros.detalleDelPerro.domain.model.Fotos

interface FotosRepository {
    suspend fun obtenerFotosApi(breed_name: List<String>): Fotos
}