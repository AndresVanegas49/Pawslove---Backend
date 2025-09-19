package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Administradores;
import com.Pawslove.PawsloveV1.repository.IadministradoresRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IadministradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradoresService implements IadministradoresService {
    private final IadministradoresRepository administradoresRepository;

    @Autowired
    public AdministradoresService(IadministradoresRepository administradoresRepository) {
        this.administradoresRepository = administradoresRepository;
    }

    @Override
    public List<Administradores> findAll() {
        return administradoresRepository.findAll();
    }

    @Override
    public Optional<Administradores> findById(Long id) {
        return administradoresRepository.findById(id);
    }

    @Override
    public Administradores save(Administradores administrador) {
        return administradoresRepository.save(administrador);
    }

    @Override
    public void deleteById(Long id) {
        administradoresRepository.deleteById(id);
    }

    @Override
    public Optional<Administradores> update(Long id, Administradores administradorDetalles) {
        Optional<Administradores> adminisdorOptional = administradoresRepository.findById(id);
        if (adminisdorOptional.isPresent()) {
            Administradores administradorActualizado = adminisdorOptional.get();
            administradorActualizado.setNombre(administradorDetalles.getNombre());
            administradorActualizado.setApellido(administradorDetalles.getApellido());
            administradorActualizado.setEmail(administradorDetalles.getEmail());
            administradorActualizado.setContrasena(administradorDetalles.getContrasena()); // Actualiza el usuario
            administradorActualizado.setEstado(administradorDetalles.isEstado()); // Actualiza el producto
            administradoresRepository.save(administradorActualizado);
            return Optional.of(administradorActualizado);
        } else {
            return Optional.empty();
        }
    }
}//Cierre de clase service
