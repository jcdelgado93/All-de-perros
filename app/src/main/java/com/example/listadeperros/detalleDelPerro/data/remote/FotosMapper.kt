package com.example.listadeperros.detalleDelPerro.data.remote

import com.example.listadeperros.detalleDelPerro.domain.model.Fotos

class FotosMapper {

    fun mapToEntityFotos(fotosModel: FotosModel): Fotos {
        return Fotos(fotosModel.message)
    }
}