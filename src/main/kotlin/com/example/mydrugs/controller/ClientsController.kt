package com.example.mydrugs.controller


import com.example.mydrugs.model.Clients
import com.example.mydrugs.service.ClientsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Clients")
class ClientsController {
    @Autowired
    lateinit var ClientsService: ClientsService

    @GetMapping
    fun list ():List <Clients>{
        return ClientsService.list()
    }
    @PostMapping
    fun save (@RequestBody modelo: Clients): ResponseEntity<Clients> {
        return ResponseEntity(ClientsService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo: Clients):ResponseEntity<Clients>{
        return ResponseEntity(ClientsService.update(modelo), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody modelo: Clients):ResponseEntity<Clients>{
        return ResponseEntity(ClientsService.updateName(modelo), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(ClientsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return ClientsService.delete(id)
    }
}