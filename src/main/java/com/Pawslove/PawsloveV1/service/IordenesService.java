package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Ordenes;

import java.util.List;
import java.util.Optional;

public interface IordenesService {
    List<Ordenes> findAll();
    Optional<Ordenes> findById(Long id);
    Ordenes save(Ordenes orden);
    void deleteById(Long id);
    Optional<Ordenes> update(Long id, Ordenes ordenDetalles);
}
