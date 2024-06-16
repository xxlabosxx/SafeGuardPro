package com.estudadospelanasa.safeguardpro.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.estudadospelanasa.safeguardpro.service.model.Login
import com.estudadospelanasa.safeguardpro.viewmodel.FuncionarioViewModel
import com.gustavolabos.SafeGuardPro.R
import com.gustavolabos.SafeGuardPro.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val viewModelFuncionario: FuncionarioViewModel by viewModels()

    //criar o binding
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var senha = ""
        var cpf = ""

        binding.logar.setOnClickListener {
            cpf = binding.emailtxt.editableText.toString()
            senha = binding.senhatxt.editableText.toString()

            if ((cpf.isBlank() || cpf.isEmpty()) || (senha.isBlank() || senha.isEmpty())) {
                makeText(requireContext(), "Preencha os campos", LENGTH_LONG).show()
            } else {
                viewModelFuncionario.getFuncionario(cpf.toInt())
            }
        }

        viewModelFuncionario.funcionario.observe(viewLifecycleOwner) {
            if (it.senha == senha && it.cpf == cpf){
                Login.userConected(it.id, it.cpf, it.admin)

                findNavController().navigate(R.id.telaInicialFragment)
            } else {
                makeText(requireContext(), "Usuario ou senha inválidos", LENGTH_LONG).show()
            }
        }
    }
}