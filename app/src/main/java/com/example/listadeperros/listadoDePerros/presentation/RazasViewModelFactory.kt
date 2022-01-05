package com.example.listadeperros.listadoDePerros.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listadeperros.listadoDePerros.domain.ObtenerRazasUseCase

class RazasViewModelFactory(
    private val obtenerApiUseCase : ObtenerRazasUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerRazasUseCase::class.java)
            .newInstance(obtenerApiUseCase)
    }
}