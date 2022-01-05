package com.example.listadeperros.detalleDelPerro.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeperros.detalleDelPerro.domain.ObtenerFotosUseCase
import com.example.listadeperros.detalleDelPerro.domain.model.Fotos
import kotlinx.coroutines.launch
import java.lang.Exception

class FotosViewModel(
    private val fotosUseCase: ObtenerFotosUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<FotosState>()

    fun getLiveData() = liveData

    fun obtenerFotos(breed_name: List<String>) {
        liveData.postValue(FotosState.LoadingState)
        viewModelScope.launch {
            try {
                val result = fotosUseCase.execute(breed_name)
                handleResult(result)
            } catch (exception: Exception) {
                handleError(exception)
            }
        }
    }

    private fun handleResult(result: Fotos) {
        liveData.postValue(FotosState.Obtenerfotos(result))
    }

    private fun handleError(exception: Exception) {
        liveData.postValue(FotosState.Error(exception))
    }

}