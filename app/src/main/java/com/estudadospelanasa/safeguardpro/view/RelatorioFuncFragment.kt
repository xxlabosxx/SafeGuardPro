package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroEpiBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentRelatorioFuncBinding

class RelatorioFuncFragment : Fragment() {
    private var _binding: FragmentRelatorioFuncBinding? = null
    private val binding: FragmentRelatorioFuncBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRelatorioFuncBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Fazer igual na AllPessoasFragment do FirstApp
    }
}