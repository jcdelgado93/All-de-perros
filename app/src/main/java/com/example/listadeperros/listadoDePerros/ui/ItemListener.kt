package com.example.listadeperros.listadoDePerros.ui

import com.example.listadeperros.listadoDePerros.domain.model.Razas

interface ItemListener {
    fun onItemClick(razas: Razas)
}