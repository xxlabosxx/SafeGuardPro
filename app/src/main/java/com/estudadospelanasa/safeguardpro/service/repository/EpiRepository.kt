package com.estudadospelanasa.safeguardpro.service.repository

import android.content.Context
import com.estudadospelanasa.safeguardpro.service.model.Epi
import com.estudadospelanasa.safeguardpro.service.repository.remote.EpiService
import com.estudadospelanasa.safeguardpro.service.repository.remote.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class EpiRepository(context: Context) {


    private val mRemote = RetrofitClient.createService(EpiService::class.java)

    private val funcionarioEmpty = Epi(0, "", "", "")

    suspend fun getEpi(): List<Epi> {
        return mRemote.getEpis()
    }

    suspend fun insertEpi(epi: Epi): Epi {
        return mRemote.createEpi(
            nome = epi.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            dataValidade = epi.dataValidade.toRequestBody("text/plain".toMediaTypeOrNull()),
            descricao = epi.descricao.toRequestBody("text/plain".toMediaTypeOrNull()),
            categoria = epi.categoriaEpi.toRequestBody("text/plain".toMediaTypeOrNull()),
            ca = epi.ca.toString().toRequestBody("text/plain".toMediaTypeOrNull())
        ).body() ?: funcionarioEmpty
    }
    suspend fun getEpi(id: Int): Epi {
        val response = mRemote.getEpiById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: funcionarioEmpty
        } else {
            funcionarioEmpty
        }
    }

    suspend fun getEpiByCa(ca: Int): Epi {
        val response = mRemote.getEpiByCa(ca)
        return if (response.isSuccessful) {
            response.body()?.first() ?: funcionarioEmpty
        } else {
            funcionarioEmpty
        }
    }

    suspend fun deleteEpi(id: Int): Boolean{
        return mRemote.deleteEpiById(id).isSuccessful
    }

    //update
    suspend fun updateEpi(epi: Epi): Epi {
        return mRemote.updateEpi(
            nome = epi.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            dataValidade = epi.dataValidade.toRequestBody("text/plain".toMediaTypeOrNull()),
            descricao = epi.descricao.toRequestBody("text/plain".toMediaTypeOrNull()),
            categoria = epi.categoriaEpi.toRequestBody("text/plain".toMediaTypeOrNull()),
            ca = epi.ca.toString().toRequestBody("text/plain".toMediaTypeOrNull()),
            id = epi.id
        ).body() ?: funcionarioEmpty
    }
}