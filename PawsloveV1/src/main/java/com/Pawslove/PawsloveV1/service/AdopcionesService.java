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

    @Override
    public Optional<Adopciones> update(Long id, Adopciones adopcionDetalles) {
        Optional<Adopciones> adopcionOptional = adopcionRepository.findById(id);
        if (adopcionOptional.isPresent()) {
            Adopciones adopcionActualizada = adopcionOptional.get();
            adopcionActualizada.setFecha(adopcionDetalles.getFecha());
            adopcionActualizada.setDocumento(adopcionDetalles.getDocumento());
            adopcionActualizada.setUsuario(adopcionDetalles.getUsuario()); // Actualiza el usuario
            adopcionActualizada.setMascota(adopcionDetalles.getMascota()); // Actualiza la mascota
            adopcionRepository.save(adopcionActualizada);
            return Optional.of(adopcionActualizada);
        } else {
            return Optional.empty();
        }
    }
}

