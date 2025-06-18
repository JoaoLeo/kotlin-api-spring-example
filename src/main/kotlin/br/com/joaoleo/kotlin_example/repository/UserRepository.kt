package br.com.joaoleo.kotlin_example.repository

import br.com.joaoleo.kotlin_example.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}