package com.example.listadeperros.detalleDelPerro.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listadeperros.R
import com.example.listadeperros.databinding.FragmentDetalleBinding
import com.example.listadeperros.detalleDelPerro.data.remote.RemoteFotosRepository
import com.example.listadeperros.detalleDelPerro.data.remote.FotosMapper
import com.example.listadeperros.detalleDelPerro.domain.ObtenerFotosUseCase
import com.example.listadeperros.detalleDelPerro.domain.model.Fotos
import com.example.listadeperros.detalleDelPerro.presentation.FotosState
import com.example.listadeperros.detalleDelPerro.presentation.FotosViewModel
import com.example.listadeperros.detalleDelPerro.presentation.FotosViewModelFactory
import com.example.listadeperros.network.api.RetrofitHandler
import com.example.listadeperros.util.MESSAGE

class DetalleFragment : Fragment(R.layout.fragment_detalle) {

    private lateinit var binding: FragmentDetalleBinding
    private lateinit var fotosAdapter: FotosAdapter
    private lateinit var fotosViewModel: FotosViewModel
    private lateinit var fotosViewModelFactory: FotosViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
        setupDependencies()
        setupLiveData()
        setupRecyclerView()
    }

    private fun setupBind(view : View) {
        binding = FragmentDetalleBinding.bind(view)
    }

    private fun setupDependencies() {
        fotosViewModelFactory = FotosViewModelFactory(
            ObtenerFotosUseCase(
                RemoteFotosRepository(
                    RetrofitHandler.obtenerFotosApi(),
                    FotosMapper()
                )
            )
        )

        fotosViewModel = ViewModelProvider(this, fotosViewModelFactory)[FotosViewModel::class.java]
    }

    private fun setupLiveData() {
        val raza = arguments?.getStringArrayList(MESSAGE)
        if (raza != null) {
            if (raza.isNotEmpty()) {
                fotosViewModel.getLiveData().observe(
                    viewLifecycleOwner,
                    { state -> subRazasState(state) }
                )

                fotosViewModel.obtenerFotos(raza)
            }
        }
    }

    private fun subRazasState(state: FotosState?) {
        when (state) {
            is FotosState.LoadingState -> mostrarCargando()
            is FotosState.Obtenerfotos -> state.fotosResult?.let { mostrarFotos(it) }
            is FotosState.Error -> state.error?.let { mostrarError(it) }
        }
    }

    private fun mostrarCargando() {
        Toast.makeText(context, "Cargando fotos", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarFotos(it: Fotos) {
        fotosAdapter = FotosAdapter(it)
        binding.rvFotos.adapter = fotosAdapter
    }

    private fun mostrarError(it: Throwable) {
        Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
    }


    private fun setupRecyclerView() {
        binding.apply {
            rvFotos.setHasFixedSize(true)
            rvFotos.layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }
}