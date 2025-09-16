package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Donaciones;

import java.util.List;
import java.util.Optional;

public interface IdonacionesService {
    List<Donaciones> findAll();
    Optional<Donaciones> findById(Long id);
    Donaciones save(Donaciones donacion);
    void deleteById(Long id);
    Optional<Donaciones> update(Long id, Donaciones donacionDetalles);
}
