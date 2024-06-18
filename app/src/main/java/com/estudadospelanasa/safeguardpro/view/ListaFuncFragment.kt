package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudadospelanasa.safeguardpro.viewmodel.FuncionarioViewModel
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentListaFuncBinding
import com.programardores.safeguardpro.view.adapter.FuncionarioAdapter

class ListaFuncFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    private lateinit var adapter: FuncionarioAdapter


    private var _binding: FragmentListaFuncBinding? = null
    private val binding: FragmentListaFuncBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaFuncBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Quando clicar em algum item da lista vai ser redirecionado
        adapter = FuncionarioAdapter(viewModel.funcionarioList.value){funcionario ->
            val funcionarioBundle = Bundle()
            funcionarioBundle.putInt("id", funcionario.id)
            arguments = funcionarioBundle
            findNavController().navigate(R.id.cadastroFuncFragment, arguments)
        }


        //Configura a recycler
        val recycler = binding.rvFunc
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //obeserva
        viewModel.funcionarioList.observe(viewLifecycleOwner){
            adapter.updateFuncionario(it)
        }

         //Navegar para a tela de cadastro de funcionario
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.cadastroFuncFragment)
        }

        // Carregar as funcionario cadastradas
        viewModel.loadFuncionario()
    }
}