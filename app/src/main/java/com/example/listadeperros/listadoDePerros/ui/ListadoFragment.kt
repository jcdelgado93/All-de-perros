package com.example.listadeperros.listadoDePerros.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadeperros.R
import com.example.listadeperros.databinding.FragmentListadoBinding
import com.example.listadeperros.listadoDePerros.data.remote.RazasMapper
import com.example.listadeperros.listadoDePerros.data.remote.RemoteRazasRepository
import com.example.listadeperros.listadoDePerros.domain.ObtenerRazasUseCase
import com.example.listadeperros.listadoDePerros.domain.model.Razas
import com.example.listadeperros.listadoDePerros.presentation.RazasState
import com.example.listadeperros.listadoDePerros.presentation.RazasViewModel
import com.example.listadeperros.listadoDePerros.presentation.RazasViewModelFactory
import com.example.listadeperros.network.api.RetrofitHandler
import com.example.listadeperros.util.razasBundle

class ListadoFragment : Fragment(R.layout.fragment_listado) {

    private lateinit var binding: FragmentListadoBinding
    private lateinit var razasAdapter: RazasAdapter
    private lateinit var razasViewModel: RazasViewModel
    private lateinit var razasViewModelFactory: RazasViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
        setupDependencies()
        setupLiveData()
        setupRecyclerView()
        obtenerViewModel()
    }

    private fun setupBind(view: View) {
        binding = FragmentListadoBinding.bind(view)
    }

    private fun setupDependencies() {
        razasViewModelFactory = RazasViewModelFactory(
            ObtenerRazasUseCase(
                RemoteRazasRepository(
                    RetrofitHandler.obtenerRazasApi(),
                    RazasMapper()
                )
            )
        )
        razasViewModel = ViewModelProvider(this, razasViewModelFactory)[RazasViewModel::class.java]
    }

    private fun setupLiveData() {
        razasViewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> handleState(state) }
        )
        razasViewModel.obtenerRazas()
    }

    private fun handleState(state: RazasState?) {
        when (state) {
            is RazasState.LoadingState -> mostrarCargando()
            is RazasState.ObtenerRazas -> state.razasResult?.let { mostrarLista(it) }
            is RazasState.Error -> state.error?.let { mostrarError(it) }
        }
    }

    private fun mostrarCargando() {
        Toast.makeText(context, "Cargando listado", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarLista(razas: Razas) {
        razasAdapter = RazasAdapter(
            razas, object : ItemListener {
                override fun onItemClick(razas: Razas) {
                    view?.let { safeView ->
                        Navigation.findNavController(safeView)
                            .navigate(
                                R.id.action_listadoFragment_to_detalleFragment,
                                razasBundle(razas)
                            )
                    }
                }
            }
        )
        binding.rvRazas.adapter = razasAdapter
    }

    private fun mostrarError(error: Throwable) {
        Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_LONG).show()
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvRazas.setHasFixedSize(true)
            rvRazas.layoutManager = LinearLayoutManager(requireContext())
            rvRazas.itemAnimator = DefaultItemAnimator()
        }
    }

    private fun obtenerViewModel() {
        razasViewModel.obtenerRazas()
    }
}