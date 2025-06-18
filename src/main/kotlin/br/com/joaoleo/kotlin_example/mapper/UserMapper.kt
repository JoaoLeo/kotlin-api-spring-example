package br.com.joaoleo.kotlin_example.mapper

import br.com.joaoleo.kotlin_example.dto.CreateUserDTO
import br.com.joaoleo.kotlin_example.dto.UserDTO
import br.com.joaoleo.kotlin_example.entity.Address
import br.com.joaoleo.kotlin_example.entity.User

fun User.toDTO(): UserDTO = UserDTO(
    id = this.id,
    login = this.login,
    firstname = this.firstname,
    lastname = this.lastname,
    description = this.description,
    adressList = this.items.map(Address::toDTO)
)

fun CreateUserDTO.update(id: Long) : User = User(
    id = id,
    login = this.login,
    firstname = this.firstname,
    lastname = this.lastname,
    description = this.description,
)

fun CreateUserDTO.toEntity() : User = User(
    id = this.id,
    login = this.login,
    firstname = this.firstname,
    lastname = this.lastname,
    description = this.description,
)