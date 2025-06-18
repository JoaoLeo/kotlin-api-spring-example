package br.com.joaoleo.kotlin_example.mapper

import br.com.joaoleo.kotlin_example.dto.AddressDTO
import br.com.joaoleo.kotlin_example.entity.Address

fun Address.toDTO() : AddressDTO = AddressDTO(
    id = this.id,
    title = this.title,
    country = this.country,
    city = this.city,
    town = this.town,
    detail = this.detail
)
