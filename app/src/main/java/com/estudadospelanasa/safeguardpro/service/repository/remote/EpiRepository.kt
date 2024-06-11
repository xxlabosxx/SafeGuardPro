//package com.estudadospelanasa.safeguardpro.service.repository.remote
//
//import com.estudadospelanasa.safeguardpro.service.model.Epi
//import okhttp3.MediaType.Companion.toMediaTypeOrNull
//import okhttp3.RequestBody.Companion.toRequestBody
//
//class EpiRepository {
//
//
//    private val mRemote = RetrofitClient.createService(EpiService::class.java)
//
//    private val funcionarioEmpty = Epi(0, "", "", "")
//
//    suspend fun getEpi(): List<Epi> {
//        return mRemote.getEpis()
//    }
//
//    suspend fun insertEpi(funcionario: Epi): Epi {
//        return mRemote.createEpi<Any?>(
//            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
//            cpf = funcionario.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
//            email = funcionario.email.toRequestBody("text/plain".toMediaTypeOrNull()),
//        ).body() ?: funcionarioEmpty
//    }
//    suspend fun getEpi(id: Int): Epi {
//        val response = mRemote.getEpiById<Any?>(id)
//        return if (response.isSuccessful) {
//            response.body()?.first() ?: funcionarioEmpty
//        } else {
//            funcionarioEmpty
//        }
//    }
//    suspend fun deleteEpi(id: Int): Boolean{
//        return mRemote.deleteEpi<Any?>(id).isSuccessful
//    }
//
//    //update
//    suspend fun updateEpi(funcionario: Epi): Epi {
//        return mRemote.updateEpi<Any?>(
//            nome = funcionario.nome.toRequestBody("text/plain".toMediaTypeOrNull()),
//            cpf = funcionario.cpf.toRequestBody("text/plain".toMediaTypeOrNull()),
//            email = funcionario.email.toRequestBody("text/plain".toMediaTypeOrNull()),
//            id = funcionario.id
//        ).body() ?: funcionarioEmpty
//    }
//}