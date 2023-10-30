package com.example.mydrugs.service


import com.example.mydrugs.model.Clients
import com.example.mydrugs.model.Products
import com.example.mydrugs.respository.ClientsRepository
import com.example.mydrugs.respository.ProductsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ClientsService {
    @Autowired
    lateinit var ClientsRepository: ClientsRepository
    @Autowired
    lateinit var ProductsRepository: ProductsRepository //inyectado papa
    fun list ():List<Clients>{
        return ClientsRepository.findAll()
    }
    fun save(Clientes: Clients): Clients{
        try {
            ProductsRepository.findById(Clientes.id)
                    ?: throw Exception("Id del cliente no encontrada")
            return ClientsRepository.save(Clientes)
        }catch (ex : Exception){
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun update(model: Clients): Clients {
        try {
            ClientsRepository.findById(model.id)
                    ?: throw Exception("ID no existe")

            return ClientsRepository.save(model)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(modelo:Clients): Clients{
        try{
            val response = ClientsRepository.findById(modelo.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                Dirección=modelo.Dirección //un atributo del modelo
            }
            return ClientsRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Clients?{
        return ClientsRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = ClientsRepository.findById(id)
                    ?: throw Exception("ID no existe")
            ClientsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}

