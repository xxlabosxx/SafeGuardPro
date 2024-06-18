package com.estudadospelanasa.safeguardpro.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.estudadospelanasa.safeguardpro.service.model.Funcionario
import com.estudadospelanasa.safeguardpro.viewmodel.FuncionarioViewModel
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroFuncBinding
import java.time.LocalDateTime

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
        arguments?.let {
            viewModel.getFuncionario(it.getInt("id"))
        }
        binding.btnCadastroFunc.setOnClickListener {
            var nome = binding.edtNomeFunc.editableText.toString()
            var cpf = binding.edtCpf.editableText.toString()
            var senha = binding.edtSenha.toString()

            val funcionario = Funcionario(
                nome = nome,
                cpf = cpf,
                senha = senha,
                )

            viewModel.funcionario.value?.let {
                funcionario.id = it.id
                viewModel.update(funcionario)
            }?:run {
                viewModel.insert(funcionario)
            }

            binding.edtNomeFunc.editableText.clear()
            binding.edtCpf.editableText.clear()
            findNavController().navigateUp()
        }

        binding.btnDeletar.setOnClickListener{
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoa")
                .setMessage("Deseja excluir?")
                .setPositiveButton("Excluir?"){ _,_ ->
                    viewModel.delete(viewModel.funcionario.value?. id ?:0)
                    findNavController().navigateUp()
                }
                .setNegativeButton("Não excluir"){_,_ ->}
                .show()}

        viewModel.funcionario.observe(viewLifecycleOwner){pessoa ->
            binding.edtNomeFunc.setText(pessoa.nome)
            binding.edtCpf.setText(pessoa.cpf)

            binding.btnDeletar.visibility = View.VISIBLE
        }
    }
}