package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Administradores;

import java.util.List;
import java.util.Optional;

public interface IadministradoresService {
    List<Administradores> findAll();
    Optional<Administradores> findById(Long id);
    Administradores save(Administradores administrador);
    void deleteById(Long id);
    Optional<Administradores> update(Long id, Administradores administradorDetalles);
}
