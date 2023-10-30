package com.example.mydrugs.respository

import com.example.mydrugs.model.Clients
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientsRepository: JpaRepository<Clients, Long?> {

    fun findById (id: Long?): Clients?

}