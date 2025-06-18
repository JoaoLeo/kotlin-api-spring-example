package br.com.joaoleo.kotlin_example.dto

data class CreateUserDTO(
    var id: Long?,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    val addressList: List<Long>? =  mutableListOf()
)
