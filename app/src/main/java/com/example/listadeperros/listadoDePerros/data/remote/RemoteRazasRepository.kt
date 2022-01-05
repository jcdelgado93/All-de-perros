package com.example.listadeperros.listadoDePerros.data.remote

import com.example.listadeperros.listadoDePerros.domain.RazasRepository
import com.example.listadeperros.listadoDePerros.domain.model.Razas

class RemoteRazasRepository(
    private val apiRazas: ApiRazas,
    private val razasMapper: RazasMapper
): RazasRepository {

    override suspend fun obtenerRazasApi(): Razas {
        val razas = apiRazas.obtenerRazas()
        return razasMapper.mapToEntityRazas(razas)
    }
}