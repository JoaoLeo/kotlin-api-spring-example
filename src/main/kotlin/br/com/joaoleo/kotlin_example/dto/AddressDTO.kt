package br.com.joaoleo.kotlin_example.dto

data class AddressDTO(
    var id: Long?,
    val title: String,
    val country: String,
    val city: String,
    val town: String? = null,
    val detail: String
)
