package br.com.joaoleo.kotlin_example.service

import br.com.joaoleo.kotlin_example.dto.AddressDTO
import br.com.joaoleo.kotlin_example.entity.Address
import br.com.joaoleo.kotlin_example.mapper.toDTO
import br.com.joaoleo.kotlin_example.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(private val repository: AddressRepository) {

    fun getAll(): List<AddressDTO> =
        repository.findAll().map(Address::toDTO)

    fun getById(id: Long): AddressDTO =
        repository.findById(id)
            .orElseThrow { ClassNotFoundException("Endereco $id não encontrado") }
            .toDTO()

    fun getEntityById(id: Long): Address =
        repository.findById(id)
            .orElseThrow { ClassNotFoundException("Endereco $id não encontrado") }

    fun deleteByUserId(id: Long) =
        repository.deleteAdressByUserId(id)

}