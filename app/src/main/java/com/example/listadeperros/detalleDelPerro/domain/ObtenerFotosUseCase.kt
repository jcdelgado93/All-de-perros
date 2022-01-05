package com.example.listadeperros.detalleDelPerro.domain

import com.example.listadeperros.detalleDelPerro.domain.model.Fotos

class ObtenerFotosUseCase(
    private val repository: FotosRepository
) {
    suspend fun execute(breed_name: List<String>): Fotos = repository.obtenerFotosApi(breed_name)
}