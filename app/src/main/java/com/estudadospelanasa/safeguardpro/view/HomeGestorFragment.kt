package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroEpiBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentHomeGestorBinding

class HomeGestorFragment : Fragment() {
    private var _binding: FragmentHomeGestorBinding? = null
    private val binding: FragmentHomeGestorBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeGestorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Fazer os clicks dos botoes para navegar para as telas correspondentes

        binding.btnCadastroEPI.setOnClickListener {
            findNavController().navigate(R.id.cadastroEpiFragment)
        }

        binding.btnCadastroFunc.setOnClickListener {
            findNavController().navigate(R.id.cadastroFuncFragment)
        }
        binding.btnEmprestimoEPI.setOnClickListener {
            findNavController().navigate(R.id.entregaFragment)
        }
        binding.btnListaEPI.setOnClickListener {
            findNavController().navigate(R.id.listaEpiFragment)
        }
        binding.btnListaFunc.setOnClickListener {
            findNavController().navigate(R.id.listaFuncFragment)
        }
    }
}
