package com.example.listadeperros.detalleDelPerro.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.listadeperros.databinding.ItemSubrazasBinding
import com.example.listadeperros.detalleDelPerro.domain.model.Fotos
import com.squareup.picasso.Picasso

class FotosViewHolder(
    private val binding: ItemSubrazasBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(fotos: Fotos) {
        binding.apply {
            Picasso.get().load(fotos.message[position]).into(ivFoto)
        }
    }
}