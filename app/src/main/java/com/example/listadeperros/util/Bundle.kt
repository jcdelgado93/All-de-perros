package com.example.listadeperros.util

import android.os.Bundle
import com.example.listadeperros.listadoDePerros.domain.model.Razas
import kotlin.collections.ArrayList

const val MESSAGE = "message"

fun razasBundle(razas: Razas): Bundle {
    val bundle = Bundle()
    val lista = ArrayList<String>()
    bundle.putStringArrayList(MESSAGE, razas.message.toCollection(lista))
    return bundle
}

fun razasBundle(bundle: Bundle): Razas {
    val message = bundle.getStringArrayList(MESSAGE)
    val list: List<String> = message?.toList() as List<String>
    return Razas(list)
}