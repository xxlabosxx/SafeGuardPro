package com.estudadospelanasa.safeguardpro.service.model

data class Funcionario(
    var id: Int = 0,
    var nome: String = "",
    var email: String = "",
    var cpf: String = "",
    var senha: String = "",
    var admin: Boolean = false,
)
