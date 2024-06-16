package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.estudadospelanasa.safeguardpro.viewmodel.FuncionarioViewModel
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroFuncBinding

class CadastroFuncFragment : Fragment() {
    private val viewModel: FuncionarioViewModel by viewModels()

    private var _binding: FragmentCadastroFuncBinding? = null
    private val binding: FragmentCadastroFuncBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCadastroFuncBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Fazer igual a tela de PessoaFragment no FirstApp
    }
}