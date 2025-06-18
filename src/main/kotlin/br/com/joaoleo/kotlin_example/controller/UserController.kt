package br.com.joaoleo.kotlin_example.controller

import br.com.joaoleo.kotlin_example.dto.CreateUserDTO
import br.com.joaoleo.kotlin_example.dto.UserDTO
import br.com.joaoleo.kotlin_example.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<UserDTO>> =
        ResponseEntity.ok(userService.getAll())

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserDTO> =
        ResponseEntity.ok(userService.getById(id))

    @PostMapping
    fun create(@RequestBody dto: CreateUserDTO): ResponseEntity<UserDTO> {
        val userCreated = userService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        userService.delete(id)
        return ResponseEntity.noContent().build()
    }
}