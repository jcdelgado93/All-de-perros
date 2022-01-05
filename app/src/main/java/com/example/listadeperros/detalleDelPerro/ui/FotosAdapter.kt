package com.example.listadeperros.detalleDelPerro.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadeperros.databinding.ItemSubrazasBinding
import com.example.listadeperros.detalleDelPerro.domain.model.Fotos

class FotosAdapter(
    private val fotos: Fotos
): RecyclerView.Adapter<FotosViewHolder>() {

    private lateinit var binding: ItemSubrazasBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FotosViewHolder {
        binding = ItemSubrazasBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return FotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FotosViewHolder, position: Int) {
        holder.bind(fotos)
    }

    override fun getItemCount(): Int {
        return fotos.message.size
    }
}