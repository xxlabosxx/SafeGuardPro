package com.estudadospelanasa.safeguardpro.service.repository.remote

import com.estudadospelanasa.safeguardpro.service.model.Epi
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface EpiService {

    @GET("get_epis")
    suspend fun getEpis(): List<Epi>

    @GET("get_epi/{epi_id")
    suspend fun getEpiById(@Path("epi_id") id: Int): Response<List<Epi>>

    @GET("select_epis/{epi_ca}")
    suspend fun getEpiByCa(@Part("epi_ca") ca: Int): Response<List<Epi>>

    @Multipart
    @PUT("update_epi/{epi_id}")
    suspend fun updateEpi(
        @Path("epi_id") id: Int,
        @Part("nome") nome: RequestBody,
        @Part("dataValidade") dataValidade: RequestBody,
        @Part("descricao") descricao: RequestBody,
        @Part("categoria") categoria: RequestBody,
        @Part("ca") ca: RequestBody,
    ): Response<Epi>

    @Multipart
    @POST("add_epi")
    suspend fun createEpi(
        @Part("nome") nome: RequestBody,
        @Part("dataValidade") dataValidade: RequestBody,
        @Part("descricao") descricao: RequestBody,
        @Part("categoria") categoria: RequestBody,
        @Part("ca") ca: RequestBody,
    ): Response<Epi>

    @DELETE("delete_epi/{epi_id}")
    suspend fun deleteEpiById(@Path("epi_id") id: Int): Response<Epi>
}