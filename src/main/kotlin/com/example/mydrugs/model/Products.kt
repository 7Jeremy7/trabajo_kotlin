package com.example.mydrugs.model

import jakarta.persistence.*

@Entity
@Table(name = "Productos")
class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="Nombre_del_Producto")
    var NombredelProducto: String? = null
    var Descripción: String? = null
    var Inventario: String? = null
}