package com.Pawslove.PawsloveV1.service.interfaces;

import com.Pawslove.PawsloveV1.modelo.Productos;

public interface IproductosService extends IgenericService<Productos, Long>{
    // Crear o actualizar un producto
    Productos guardarProducto(Productos producto);

    // Obtener todos los productos
    java.util.List<Productos> obtenerTodosLosProductos();

    // Obtener un producto por ID
    java.util.Optional<Productos> obtenerProductoPorId(Long id);

    // Eliminar un producto por ID
    void eliminarProducto(Long id);

    // Eliminar todos los productos
    void eliminarTodosLosProductos();

    // Obtener productos por nombre (usando metodo de repositorio)
    java.util.List<Productos> buscarPorNombre(String nombre);
}
