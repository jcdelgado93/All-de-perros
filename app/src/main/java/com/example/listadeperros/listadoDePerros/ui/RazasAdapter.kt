package com.example.listadeperros.listadoDePerros.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadeperros.databinding.ItemRazasDePerrosBinding
import com.example.listadeperros.listadoDePerros.domain.model.Razas

class RazasAdapter(
    private val razas: Razas,
    private val listener: ItemListener
) : RecyclerView.Adapter<RazasViewHolder>() {

    private lateinit var binding: ItemRazasDePerrosBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazasViewHolder {
        binding = ItemRazasDePerrosBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return RazasViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: RazasViewHolder, position: Int) {
        holder.bind(razas)
    }

    override fun getItemCount(): Int {
        return razas.message.size
    }
}