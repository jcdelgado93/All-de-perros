package com.example.listadeperros.listadoDePerros.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.listadeperros.databinding.ItemRazasDePerrosBinding
import com.example.listadeperros.listadoDePerros.domain.model.Razas

class RazasViewHolder(
    private val binding: ItemRazasDePerrosBinding,
    private val listener: ItemListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(razas: Razas) {
        binding.apply {
            tvRaza.text = razas.message[position]
            tvRaza.setOnClickListener { listener.onItemClick(razas) }
        }
    }
}