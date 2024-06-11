package com.estudadospelanasa.safeguardpro.service.repository.remote

import android.content.Context
import com.estudadospelanasa.safeguardpro.service.model.Epi
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class EpiRepository(context: Context) {
    private val mRemote = RetrofitClient.createService(EpiService::class.java)


    private val epiEmpty = Epi(0, "", "", "")

    suspend fun getEpis(): List<Epi> {
        return mRemote.getEpis()
    }

    suspend fun insertEpi(epi: Epi): Epi {
        return mRemote.createEpi(
            nome = epi.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            email = epi.email.toRequestBody("text/plain".toMediaTypeOrNull()),
            cpf = epi.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
            ).body() ?: epiEmpty
    }

    suspend fun getEpi(id: Int): Epi {
        val response = mRemote.getEpiById(id)
        return if (response.isSuccessful) {
            response.body()?.first() ?: epiEmpty
        } else {
            epiEmpty
        }
    }

    suspend fun deleteEpi(id: Int): Boolean{
        return mRemote.deleteEpiById(id).isSuccessful
    }

    suspend fun updateEpi(epi: Epi): Epi {
        return mRemote.updateEpi(
            nome = epi.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
            cpf = epi.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
            email = epi.email.toRequestBody("text/plain".toMediaTypeOrNull()),
            epiId = epi.id
        ).body() ?: epiEmpty
    }
}