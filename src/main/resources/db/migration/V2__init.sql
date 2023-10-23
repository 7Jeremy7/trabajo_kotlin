CREATE TABLE IF NOT EXISTS Productos(
    id SERIAL,
    Nombre_del_Producto VARCHAR(100),
    Descripción VARCHAR(100),
    Inventario VARCHAR (50),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS Clientes(
      id SERIAL,
      Nombre_del_Cliente VARCHAR(100),
      Correo_electronico VARCHAR(100),
      Dirección VARCHAR(100),
      idProducto SERIAL,
      PRIMARY KEY (id),
      FOREIGN KEY (idProducto) REFERENCES Clientes(id)
);
