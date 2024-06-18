package com.programardores.safeguardpro.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estudadospelanasa.safeguardpro.service.model.Entrega
import com.estudadospelanasa.safeguardpro.view.EmprestimoFragment
import com.gustavolabos.SafeGuardPro.databinding.FragmentEmprestimoBinding

class EmprestimoAdapter(entregas: List<Entrega>?, private val clickListListener: (Entrega) -> Unit) :
    RecyclerView.Adapter<EmprestimoAdapter.EntregaViewHolder>() {

    //Criar uma lista vazia de entregas
    private var entregaList: List<Entrega> = arrayListOf()

    class EntregaViewHolder(private val binding: FragmentEmprestimoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //Carrega as informações da entrega na lista
        fun bind(entrega: Entrega, clickListListener: (Entrega) -> Unit) {

            binding.root.setOnClickListener {
                clickListListener(entrega)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntregaViewHolder {

        //configura o binding da lista
        val listItemEmprestimo =
            FragmentEmprestimoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntregaViewHolder(listItemEmprestimo)
    }

    override fun getItemCount(): Int {
        return  entregaList.count()
    }

    override fun onBindViewHolder(holder: EntregaViewHolder, position: Int) {
        holder.bind(entregaList[position], clickListListener)
    }

    // carrega a lista de entregas paara serem exibidas
    fun updateEntrega(list: List<Entrega>){
        entregaList = list
        notifyDataSetChanged()
    }
}
