package com.example.listadeperros.detalleDelPerro.data.remote

import com.example.listadeperros.detalleDelPerro.domain.FotosRepository
import com.example.listadeperros.detalleDelPerro.domain.model.Fotos

class RemoteFotosRepository(
    private val apiFotos: ApiFotos,
    private val fotosMapper: FotosMapper
): FotosRepository {

    override suspend fun obtenerFotosApi(breed_name: List<String>): Fotos {
        val subRazas = apiFotos.obtenerFotos(breed_name)
        return fotosMapper.mapToEntityFotos(subRazas)
    }
}