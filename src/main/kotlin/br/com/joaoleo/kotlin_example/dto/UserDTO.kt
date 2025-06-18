package br.com.joaoleo.kotlin_example.dto

data class UserDTO (
    var id: Long?,
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    var adressList: List<AddressDTO>  = emptyList()
)
