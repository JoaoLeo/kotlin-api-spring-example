package br.com.joaoleo.kotlin_example.repository

import br.com.joaoleo.kotlin_example.entity.Address
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, Long> {

    @Query("delete from Address a where a.user.id = ?1 ")
    fun deleteAdressByUserId(id: Long)
}