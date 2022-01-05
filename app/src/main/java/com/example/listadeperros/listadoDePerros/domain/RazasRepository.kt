package com.example.listadeperros.listadoDePerros.domain

import com.example.listadeperros.listadoDePerros.domain.model.Razas

interface RazasRepository {
    suspend fun obtenerRazasApi(): Razas
}