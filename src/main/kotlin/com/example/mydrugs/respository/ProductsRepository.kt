package com.example.mydrugs.respository

import com.example.mydrugs.model.Products
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsRepository: JpaRepository<Products, Long?> {

    fun findById (id: Long?): Products?

}
