package com.estudadospelanasa.safeguardpro.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.estudadospelanasa.safeguardpro.service.model.Epi
import com.estudadospelanasa.safeguardpro.viewmodel.EpiViewModel
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroEpiBinding
import com.gustavolabos.SafeGuardPro.databinding.FragmentCadastroFuncBinding
import java.time.LocalDateTime

class CadastroEpiFragment : Fragment() {
    private val viewModel: EpiViewModel by viewModels()

    private var _binding: FragmentCadastroEpiBinding? = null
    private val binding: FragmentCadastroEpiBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCadastroEpiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Fazer igual a tela de PessoaFragment no FirstApp
        arguments?.let {
            viewModel.getEpi(it.getInt("id"))
        }
        binding.btnCadastroFunc.setOnClickListener {
            var nome = binding.EPInome.editableText.toString()
            var dataValidade = binding.edtDataValidade.editableText.toString()
            var ca = binding.CAepi.editableText.toString().toInt()
            var categoriaEpi = binding.EPIdescricao.toString()
            var descricao = binding.EPIcategoria.toString()

            val epi = Epi(
                nome = nome,
                dataValidade = dataValidade,
                descricao = descricao,
                categoriaEpi = categoriaEpi,
                ca = ca,
            )

            viewModel.epi.value?.let {
                epi.id = it.id
                viewModel.update(epi)
            } ?: run {
                viewModel.insert(epi)
            }

            binding.EPInome.editableText.clear()
            binding.edtDataValidade.editableText.clear()
            binding.EPIdescricao.editableText.clear()
            binding.EPIcategoria.editableText.clear()
            findNavController().navigateUp()
        }

        binding.btnDeletar.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoa")
                .setMessage("Deseja excluir?")
                .setPositiveButton("Excluir?") { _, _ ->
                    viewModel.delete(viewModel.epi.value?.id ?: 0)
                    findNavController().navigateUp()
                }
                .setNegativeButton("Não excluir") { _, _ -> }
                .show()
        }

        viewModel.epi.observe(viewLifecycleOwner) { pessoa ->
            binding.EPInome.setText(pessoa.nome)
            binding.edtDataValidade.setText(pessoa.nome)
            binding.EPIcategoria.setText(pessoa.categoriaEpi)
            binding.EPIdescricao.setText(pessoa.descricao)

            binding.btnDeletar.visibility = View.VISIBLE
        }
    }
}