package com.Pawslove.PawsloveV1.service;


import com.Pawslove.PawsloveV1.modelo.Productos;
import com.Pawslove.PawsloveV1.repository.IproductosRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {

    //Inyección del repositorio
    private IproductosRepository iproductosRepository;

    //Constructor para la inyección de dependencias
    public ProductosService(IproductosRepository iproductosRepository) {
        this.iproductosRepository = iproductosRepository;
    }

    // Crear o actualizar un producto
    public Productos guardarProducto(Productos producto) {
        return iproductosRepository.save(producto);
    }

    // Obtener todos los productos
    public java.util.List<Productos> obtenerTodosLosProductos() {
        return iproductosRepository.findAll();
    }

    // Obtener un producto por ID
    public java.util.Optional<Productos> obtenerProductoPorId(Long id) {
        return iproductosRepository.findById(id);
    }

    // Eliminar un producto por ID
    public void eliminarProducto(Long id) {
        iproductosRepository.deleteById(id);
    }

    // Eliminar todos los productos
    public void eliminarTodosLosProductos() {
        iproductosRepository.deleteAll();
    }

    // Obtener productos por nombre (usando metodo de repositorio)
    public java.util.List<Productos> buscarPorNombre(String nombre) {
        return iproductosRepository.findByNombre(nombre);
    }
}
