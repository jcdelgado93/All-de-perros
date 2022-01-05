package com.example.listadeperros.detalleDelPerro.presentation

import com.example.listadeperros.detalleDelPerro.domain.model.Fotos

sealed class FotosState(
    open val fotosResult: Fotos? = null,
    open val error: Throwable? = null
    ) {
    object LoadingState : FotosState()

    data class Obtenerfotos(override val fotosResult: Fotos?) :
        FotosState(fotosResult = fotosResult)

    data class Error(override val error: Throwable?) :
        FotosState(error = error)
}