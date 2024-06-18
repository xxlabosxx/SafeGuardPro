package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.estudadospelanasa.safeguardpro.viewmodel.EntregaViewModel
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentEmprestimoBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentListaEmprestimoBinding
import com.programardores.safeguardpro.view.adapter.EmprestimoAdapter

class ListaEmprestimoFragment : Fragment() {
    private val viewModel: EntregaViewModel by viewModels()

    private lateinit var adapter: EmprestimoAdapter


    private var _binding: FragmentListaEmprestimoBinding? = null
    private val binding: FragmentListaEmprestimoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaEmprestimoBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Quando clicar em algum item da lista vai ser redirecionado
        adapter = EmprestimoAdapter(viewModel.entregaList.value){emprestimo ->
            val emprestimoBundle = Bundle()
            emprestimoBundle.putInt("id", emprestimo.id)
            arguments = emprestimoBundle
            findNavController().navigate(R.id.emprestimoFragment, arguments)
        }


        //Configura a recycler
        val recycler = binding.rvEmprestimo
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //obeserva
        viewModel.entregaList.observe(viewLifecycleOwner){
            adapter.updateEntrega(it)
        }

        //Navegar para a tela de cadastro de funcionario
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.emprestimoFragment)
        }

        // Carregar as funcionario cadastradas
        viewModel.loadEntrega()
    }
}