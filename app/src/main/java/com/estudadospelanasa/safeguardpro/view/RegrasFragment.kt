package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroEpiBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentListaBinding

class RegrasFragment : Fragment() {
    private var _binding: FragmentListaBinding? = null
    private val binding: FragmentListaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }
}
