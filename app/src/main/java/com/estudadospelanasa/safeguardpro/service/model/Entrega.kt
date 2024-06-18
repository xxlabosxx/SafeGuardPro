package com.estudadospelanasa.safeguardpro.service.model

data class Entrega(
    var id: Int = 0,
    var idFuncionario: Int = 0,
    var idEpi: Int = 0,
    var dataEntrega: String,
    var dataDevolver: String,
)