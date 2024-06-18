package com.estudadospelanasa.safeguardpro.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.estudadospelanasa.safeguardpro.service.model.Entrega
import com.estudadospelanasa.safeguardpro.viewmodel.EntregaViewModel
import com.gustavolabos.SafeGuardPro.databinding.FragmentEmprestimoBinding
import java.time.LocalDateTime

class EmprestimoFragment : Fragment() {
    private val viewModel: EntregaViewModel by viewModels()

    private var _binding: FragmentEmprestimoBinding? = null
    private val binding: FragmentEmprestimoBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmprestimoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Fazer igual a tela de PessoaFragment no FirstApp
        arguments?.let {
            viewModel.getEntrega(it.getInt("id"))
        }
        binding.btnCadastrarEntrega.setOnClickListener {
            var idFuncionario : Int = 0
            var idEpi : Int = 0
            var dataEntrega = binding.dataEmprestimo.toString()
            var dataDevolver = binding.dataDevolver.toString()

            val entrega = Entrega (
                idFuncionario = idFuncionario,
                idEpi = idEpi,
                dataEntrega = dataEntrega,
                dataDevolver = dataDevolver,
            )

            viewModel.entrega.value?.let {
                entrega.id = it.id
                viewModel.update(entrega)
            }?:run {
                viewModel.insert(entrega)
            }

            binding.dataEmprestimo.editableText.clear()
            binding.dataDevolver.editableText.clear()
            findNavController().navigateUp()
        }

        binding.btnDeletar.setOnClickListener{
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoa")
                .setMessage("Deseja excluir?")
                .setPositiveButton("Excluir?"){ _,_ ->
                    viewModel.delete(viewModel.entrega.value?. id ?:0)
                    findNavController().navigateUp()
                }
                .setNegativeButton("Não excluir"){_,_ ->}
                .show()}

        viewModel.entrega.observe(viewLifecycleOwner){destaque ->
            binding.dataEmprestimo.setText(destaque.dataEntrega)
            binding.dataDevolver.setText(destaque.dataDevolver)

            binding.btnDeletar.visibility = View.VISIBLE
        }
    }
}