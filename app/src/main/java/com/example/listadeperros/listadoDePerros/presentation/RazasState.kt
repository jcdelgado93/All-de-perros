package com.example.listadeperros.listadoDePerros.presentation

import com.example.listadeperros.listadoDePerros.domain.model.Razas

sealed class RazasState(
    open val razasResult: Razas? = null,
    open val error: Throwable? = null
) {
    object LoadingState : RazasState()

    data class ObtenerRazas(override val razasResult: Razas?) :
        RazasState(razasResult = razasResult)

    data class Error(override val error: Throwable?) :
        RazasState(error = error)
}