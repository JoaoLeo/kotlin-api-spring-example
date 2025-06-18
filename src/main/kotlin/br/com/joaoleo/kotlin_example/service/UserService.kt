package br.com.joaoleo.kotlin_example.service

import br.com.joaoleo.kotlin_example.dto.CreateUserDTO
import br.com.joaoleo.kotlin_example.dto.UserDTO
import br.com.joaoleo.kotlin_example.entity.Address
import br.com.joaoleo.kotlin_example.entity.User
import br.com.joaoleo.kotlin_example.mapper.toDTO
import br.com.joaoleo.kotlin_example.mapper.toEntity
import br.com.joaoleo.kotlin_example.mapper.update
import br.com.joaoleo.kotlin_example.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository,
                       private val addressService: AddressService) {

    fun getAll(): List<UserDTO> =
        repository.findAll().map(User::toDTO)

    fun getById(id: Long): UserDTO =
        repository.findById(id)
            .orElseThrow { ClassNotFoundException("Usuário $id não encontrado") }
            .toDTO()

    fun create(dto: CreateUserDTO) : UserDTO {
        val addressesToSave = mutableListOf<Address>()

        if(dto.addressList != null && dto.addressList!!.isNotEmpty()) {
            for (id in dto.addressList){
                val address = addressService.getEntityById(id)
                addressesToSave.add(address)
            }
        }
        val user = dto.toEntity()
        user.items = addressesToSave
        return repository.save(user).toDTO()
    }

    fun delete(id: Long) : Unit {
        val user = repository.findById(id)
            .orElseThrow { ClassNotFoundException("Usuário $id não encontrado") }

        repository.delete(user)
    }

}