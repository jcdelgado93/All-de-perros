package com.example.listadeperros.listadoDePerros.data.remote

import com.example.listadeperros.listadoDePerros.domain.model.Razas

class RazasMapper {

    fun mapToEntityRazas(razasModel: RazasModel): Razas {
                return Razas(razasModel.message)
    }
}