package com.example.listadeperros.listadoDePerros.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeperros.listadoDePerros.domain.ObtenerRazasUseCase
import com.example.listadeperros.listadoDePerros.domain.model.Razas
import kotlinx.coroutines.launch

class RazasViewModel(
    private val obtenerRazasUseCase: ObtenerRazasUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<RazasState>()

    fun getLiveData() = liveData

    fun obtenerRazas() {
        liveData.postValue(RazasState.LoadingState)
        viewModelScope.launch {
            try {
                val result = obtenerRazasUseCase.execute()
                handleResult(result)
            } catch (exception: Exception) {
                handleError(exception)
            }
        }
    }

    private fun handleResult(result: Razas) {
        liveData.postValue(RazasState.ObtenerRazas(result))
    }

    private fun handleError(exception: Exception) {
        liveData.postValue(RazasState.Error(exception))
    }
}