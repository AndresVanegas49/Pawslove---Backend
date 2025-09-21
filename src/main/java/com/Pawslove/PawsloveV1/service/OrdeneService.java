package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Ordenes;
import com.Pawslove.PawsloveV1.repository.IordenesRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IordenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdeneService implements IordenesService {
    private IordenesRepository ordenesRepository;

    @Autowired
    public OrdeneService(IordenesRepository ordenesRepository) {
        this.ordenesRepository = ordenesRepository;
    }

    @Override
    public List<Ordenes> findAll() {
        return ordenesRepository.findAll();
    }

    @Override
    public Optional<Ordenes> findById(Long id) {
        return ordenesRepository.findById(id);
    }

    @Override
    public Ordenes save(Ordenes orden) {
        return ordenesRepository.save(orden);
    }

    @Override
    public void deleteById(Long id) {
        ordenesRepository.deleteById(id);
    }

    @Override
    public Optional<Ordenes> update(Long id, Ordenes ordenDetalles) {
        Optional<Ordenes> ordenOptional = ordenesRepository.findById(id);
        if (ordenOptional.isPresent()) {
            Ordenes ordenActualizada = ordenOptional.get();
            ordenActualizada.setFecha(ordenDetalles.getFecha());
            ordenActualizada.setCantidad(ordenDetalles.getCantidad());
            ordenActualizada.setUsuario(ordenDetalles.getUsuario()); // Actualiza el usuario
            ordenActualizada.setProducto(ordenDetalles.getProducto()); // Actualiza el producto
            ordenesRepository.save(ordenActualizada);
            return Optional.of(ordenActualizada);
        } else {
            return Optional.empty();
        }
    }


}//Cierre de clase service
