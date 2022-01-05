package com.example.listadeperros.listadoDePerros.domain

import com.example.listadeperros.listadoDePerros.domain.model.Razas

class ObtenerRazasUseCase(
    private val razasRepository: RazasRepository
) {
    suspend fun execute(): Razas = razasRepository.obtenerRazasApi()
}