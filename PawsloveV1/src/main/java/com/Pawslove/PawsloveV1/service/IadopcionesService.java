package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Adopciones;
import java.util.List;
import java.util.Optional;

public interface IadopcionesService {
    List<Adopciones> findAll();
    Optional<Adopciones> findById(Long id);
    Adopciones save(Adopciones adopcion);
    void deleteById(Long id);
}

