package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroEpiBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentDestaquesBinding

class DestaquesFragment : Fragment() {
    private var _binding: FragmentDestaquesBinding? = null
    private val binding: FragmentDestaquesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDestaquesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEPIdestaque.setOnClickListener {
            findNavController().navigate(R.id.listaEpiFragment)
        }
    }
}
