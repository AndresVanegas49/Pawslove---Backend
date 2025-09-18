package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Adopciones;
import com.Pawslove.PawsloveV1.repository.IadopcionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopcionesService implements IadopcionesService {

    private final IadopcionesRepository adopcionRepository;

    public AdopcionesService(IadopcionesRepository adopcionRepository) {
        this.adopcionRepository = adopcionRepository;
    }

    @Override
    public List<Adopciones> findAll() { return adopcionRepository.findAll(); }

    @Override
    public Optional<Adopciones> findById(Long id) { return adopcionRepository.findById(id); }

    @Override
    public Adopciones save(Adopciones adopcion) { return adopcionRepository.save(adopcion); }

    @Override
    public void deleteById(Long id) { adopcionRepository.deleteById(id); }
}

