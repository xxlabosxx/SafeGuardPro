package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudadospelanasa.safeguardpro.service.model.Epi
import com.estudadospelanasa.safeguardpro.viewmodel.EpiViewModel
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroEpiBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentListaEpiBinding
import com.programardores.safeguardpro.view.adapter.EpiAdapter

class ListaEpiFragment : Fragment() {
    private val viewModel: EpiViewModel by viewModels()

    private lateinit var adapter: EpiAdapter


    private var _binding: FragmentListaEpiBinding? = null
    private val binding: FragmentListaEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaEpiBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Quando clicar em algum item da lista vai ser redirecionado
        adapter = EpiAdapter(viewModel.epiList.value){epi ->
            val epiBundle = Bundle()
            epiBundle.putInt("id", epi.id)
            arguments = epiBundle
            findNavController().navigate(R.id.cadastroFuncFragment, arguments)
        }


        //Configura a recycler
        val recycler = binding.rvEPI
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //obeserva
        viewModel.epiList.observe(viewLifecycleOwner){
            adapter.updateEpi(it)
        }

         //Navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.cadastroEpiFragment)
        }

        // Carregar as pessoas cadastradas
        viewModel.loadEpi()
    }
}