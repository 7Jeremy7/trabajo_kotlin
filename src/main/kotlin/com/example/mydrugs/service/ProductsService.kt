package com.example.mydrugs.service

import com.example.mydrugs.respository.ProductsRepository
import com.example.mydrugs.model.Products
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductsService {
    @Autowired
    lateinit var ProductsRepository: ProductsRepository

    fun list ():List<Products>{
        return ProductsRepository.findAll()
    }
    fun save(model: Products): Products{
        try{
            return ProductsRepository.save(model)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(model: Products): Products{
        try {
            ProductsRepository.findById(model.id)
                    ?: throw Exception("ID no existe")

            return ProductsRepository.save(model)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(modelo:Products): Products{
        try{
            val response = ProductsRepository.findById(modelo.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                Descripción=modelo.Descripción //un atributo del modelo
            }
            return ProductsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Products?{
        return ProductsRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = ProductsRepository.findById(id)
                    ?: throw Exception("ID no existe")
            ProductsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}