package com.example.mydrugs.controller

import com.example.mydrugs.model.Products
import com.example.mydrugs.service.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/mydrugs")   //endpoint
class ModelController {
    @Autowired
    lateinit var ProductsService: ProductsService

    @GetMapping
    fun list ():List <Products>{
        return ProductsService.list()
    }
    @PostMapping
    fun save (@RequestBody modelo:Products):ResponseEntity<Products>{
        return ResponseEntity(ProductsService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo:Products):ResponseEntity<Products>{
        return ResponseEntity(ProductsService.update(modelo), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody modelo:Products):ResponseEntity<Products>{
        return ResponseEntity(ProductsService.updateName(modelo), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(ProductsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return ProductsService.delete(id)
    }
    }

