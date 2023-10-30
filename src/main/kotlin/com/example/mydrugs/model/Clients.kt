package com.example.mydrugs.model

import jakarta.persistence.*

@Entity
@Table(name = "Clientes")
class Clients {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="Nombre_del_Cliente")
    var NombredelCliente: String? = null
    @Column (name="Correo_electronico")
    var CorreoElectronico: String? = null
    var Dirección: String? = null
    var idProducto: Long? = null
}

