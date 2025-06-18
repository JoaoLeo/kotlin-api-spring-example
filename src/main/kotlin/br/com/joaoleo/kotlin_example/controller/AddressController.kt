package br.com.joaoleo.kotlin_example.controller

import br.com.joaoleo.kotlin_example.dto.AddressDTO
import br.com.joaoleo.kotlin_example.service.AddressService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("addresses")
class AddressController(
    private val addressService: AddressService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<AddressDTO>> {
        val addresses = addressService.getAll()
        return ResponseEntity.ok(addresses)
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<AddressDTO> {
        val address = addressService.getById(id)
        return ResponseEntity.ok(address)
    }

    @DeleteMapping("/user/{userId}")
    fun deleteByUserId(@PathVariable userId: Long): ResponseEntity<Void> {
        addressService.deleteByUserId(userId)
        return ResponseEntity.noContent().build()
    }
}