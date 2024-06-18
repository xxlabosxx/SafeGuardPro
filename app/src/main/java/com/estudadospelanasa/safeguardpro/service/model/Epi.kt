package com.estudadospelanasa.safeguardpro.service.model

data class Epi(
    var id: Int = 0,
    var nome: String = "",
    var dataValidade: String = "",
    var descricao: String = "",
    var categoriaEpi: String = "",
    var ca: Int = 0,
)