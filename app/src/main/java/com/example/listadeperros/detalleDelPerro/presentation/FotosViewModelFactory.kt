package com.example.listadeperros.detalleDelPerro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listadeperros.detalleDelPerro.domain.ObtenerFotosUseCase

class FotosViewModelFactory(
    private val fotosUseCase: ObtenerFotosUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerFotosUseCase::class.java)
            .newInstance(fotosUseCase)
    }
}