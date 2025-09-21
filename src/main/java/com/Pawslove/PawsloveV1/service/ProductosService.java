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


    @Override
    // Crear o actualizar un producto
    public Productos save(Productos producto) {
        return iproductosRepository.save(producto);
    }

    @Override
    // Obtener todos los productos
    public java.util.List<Productos> findAll() {
        return iproductosRepository.findAll();
    }

    @Override
    // Obtener un producto por ID
    public java.util.Optional<Productos> findById(Long id) {
        return iproductosRepository.findById(id);
    }

    @Override
    // Eliminar un producto por ID
    public void deleteById(Long id) {
        iproductosRepository.deleteById(id);
    }

    @Override
    // Obtener productos por nombre (usando metodo de repositorio)
    public List<Productos> findByNombre(String nombre) {
        return iproductosRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Productos> update(Long Id, Productos productoDetalles) {
        return iproductosRepository.findById(Id).map(
                productoExistente -> {
                    productoExistente.setNombre(productoDetalles.getNombre());
                    productoExistente.setDescripcion(productoDetalles.getDescripcion());
                    productoExistente.setPrecio(productoDetalles.getPrecio());
                    productoExistente.setStock(productoDetalles.getStock());
                    productoExistente.setCategoria(productoDetalles.getCategoria());
                    return iproductosRepository.save(productoExistente);
                }
        );
    }
}
