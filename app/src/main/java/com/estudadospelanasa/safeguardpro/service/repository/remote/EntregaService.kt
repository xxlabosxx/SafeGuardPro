package com.estudadospelanasa.safeguardpro.service.repository.remote

import com.estudadospelanasa.safeguardpro.service.model.Entrega
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface EntregaService {
    @GET("get_entregas")
    suspend fun getEntregas(): List<Entrega>

    @GET("get_entrega/{entrega_id}")
    suspend fun getEntregaById(@Path("entrega_id") id: Int): Response<List<Entrega>>

    @Multipart
    @POST("add_entrega")
    suspend fun createEntrega(
        @Part("idFuncionario") idFuncionario: RequestBody,
        @Part("idEpi") idEpi: RequestBody,
        @Part("dataEntrega") dataEntrega: RequestBody,
    ): Response<Entrega>

    @Multipart
    @PUT("update_entrega/{entrega_id}")
    suspend fun updateEntrega(
        @Path("entrega_id") entregaId: Int,
        @Part("idFuncionario") idFuncionario: RequestBody,
        @Part("idEpi") idEpi: RequestBody,
        @Part("dataEntrega") dataEntrega: RequestBody,
    ): Response<Entrega>

    @DELETE("delete_entrega/{entrega_id}")
    suspend fun deleteEntregaById(@Path("entrega_id") id: Int): Response<Entrega>
}