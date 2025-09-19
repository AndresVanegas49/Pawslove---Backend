package com.Pawslove.PawsloveV1.service;


import com.Pawslove.PawsloveV1.modelo.Productos;
import com.Pawslove.PawsloveV1.repository.IproductosRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IproductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService implements IproductosService {

    //Inyección del repositorio
    private IproductosRepository iproductosRepository;

    @Autowired
    public ProductosService(IproductosRepository iproductosRepository) {
        this.iproductosRepository = iproductosRepository;
    }

    // Crear o actualizar un producto
    @Override
    public Productos guardarProducto(Productos producto) {
        return iproductosRepository.save(producto);
    }

    // Obtener todos los productos
    @Override
    public java.util.List<Productos> obtenerTodosLosProductos() {
        return iproductosRepository.findAll();
    }

    // Obtener un producto por ID
    @Override
    public java.util.Optional<Productos> obtenerProductoPorId(Long id) {
        return iproductosRepository.findById(id);
    }

    // Eliminar un producto por ID
    @Override
    public void eliminarProducto(Long id) {
        iproductosRepository.deleteById(id);
    }

    // Eliminar todos los productos
    @Override
    public void eliminarTodosLosProductos() {
        iproductosRepository.deleteAll();
    }

    // Obtener productos por nombre (usando metodo de repositorio)
    @Override
    public java.util.List<Productos> buscarPorNombre(String nombre) {
        return iproductosRepository.findByNombre(nombre);
    }


    @Override
    public List<Productos> findAll() {
        return List.of();
    }

    @Override
    public Optional<Productos> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Productos save(Productos entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Productos> update(Long aLong, Productos entity) {
        return Optional.empty();
    }
}
