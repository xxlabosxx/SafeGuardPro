//package com.estudadospelanasa.safeguardpro.service.repository.remote
//
//import okhttp3.RequestBody
//import retrofit2.Response
//import retrofit2.http.DELETE
//import retrofit2.http.GET
//import retrofit2.http.Multipart
//import retrofit2.http.POST
//import retrofit2.http.PUT
//import retrofit2.http.Part
//import retrofit2.http.Path
//
//interface EpiService {
//
//
//    @GET("get_epis")
//    suspend fun getEpis(): List<EpiRepository>
//
//    @GET("get_epi/{epi_id}")
//    suspend fun <Epi> getEpiById(@Path("epi_id") id: Int): Response<List<Epi>>
//
//    @Multipart
//    @POST("add_epi")
//    suspend fun <Epi : Any?> createEpi(
//        @Part("nome") nome: RequestBody,
//        @Part("cpf") cpf: RequestBody,
//        @Part("email") email: RequestBody,
//    ): Response<Epi>
//
//    @Multipart
//    @PUT("update_epi/{epi_id}")
//    suspend fun <Epi : Any?> updateEpi(
//        @Path("epi_id") id: Int,
//        @Part("email") email: RequestBody,
//        @Part("nome") nome: RequestBody,
//        @Part("cpf") cpf: RequestBody,
//    ): Response<Epi>
//
//    @Multipart
//    @DELETE("delete_epi/{epi_id}")
//    suspend fun <Epi : Any?> deleteEpi(
//        @Path("epi_id") id: Int,
//    ): Response<Epi>
//}