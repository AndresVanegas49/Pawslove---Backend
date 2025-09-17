package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Mascotas;
import java.util.List;
import java.util.Optional;

public interface ImascotasService {
    List<Mascotas> findAll();
    Optional<Mascotas> findById(Long id);
    Mascotas save(Mascotas mascota);
    void deleteById(Long id);
}

