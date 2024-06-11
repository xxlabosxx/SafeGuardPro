package com.estudadospelanasa.safeguardpro.service.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.estudadospelanasa.safeguardpro.service.model.Funcionario
import com.estudadospelanasa.safeguardpro.service.repository.remote.FuncionarioService
import com.estudadospelanasa.safeguardpro.service.repository.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class FuncionarioRepository(context: Context) {

    private val mRemote =
        RetrofitClient.createService(FuncionarioService::class.java)

    private val funcionarioEmpty =
        Funcionario(0, "", "", "")

    suspend fun getFuncionario(): List<Funcionario> {
        return mRemote.getFuncionarios()
    }

    suspend fun insertFuncionario(funcionario: Funcionario): Funcionario{
        return mRemote.createFuncionario(
            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            cpf = funcionario.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
            email = funcionario.email.toRequestBody("text/plain".toMediaTypeOrNull()),
         ).body() ?: funcionarioEmpty
    }
    suspend fun getFuncionario(id: Int): Funcionario {
        val response = mRemote.getFuncionarioById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: funcionarioEmpty
        } else {
            funcionarioEmpty
        }
    }
    suspend fun deleteFuncionario(id: Int): Boolean{
        return mRemote.deleteFuncionario(id).isSuccessful
    }

    //update
    suspend fun updateFuncionario(funcionario: Funcionario): Funcionario{
        return mRemote.updateFuncionario(
            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            cpf = funcionario.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
            email = funcionario.email.toRequestBody("text/plain".toMediaTypeOrNull()),
            id = funcionario.id
        ).body() ?: funcionarioEmpty
    }
}