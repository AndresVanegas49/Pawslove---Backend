package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Mascotas;
import com.Pawslove.PawsloveV1.repository.ImascotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotasService implements ImascotasService {

    private final ImascotasRepository mascotaRepository;

    public MascotasService(ImascotasRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public List<Mascotas> findAll() { return mascotaRepository.findAll(); }

    @Override
    public Optional<Mascotas> findById(Long id) { return mascotaRepository.findById(id); }

    @Override
    public Mascotas save(Mascotas mascota) { return mascotaRepository.save(mascota); }

    @Override
    public void deleteById(Long id) { mascotaRepository.deleteById(id); }
}
