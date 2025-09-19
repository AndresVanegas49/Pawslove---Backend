package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Donaciones;
import com.Pawslove.PawsloveV1.repository.IdonacionesRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IdonacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionesService implements IdonacionesService {
    private IdonacionesRepository donacionesRepository;

    @Autowired
    public DonacionesService(IdonacionesRepository donacionesRepository) {
        this.donacionesRepository = donacionesRepository;
    }

    @Override
    public List<Donaciones> findAll() {
        return donacionesRepository.findAll();
    }

    @Override
    public Optional<Donaciones> findById(Long id) {
        return donacionesRepository.findById(id);
    }

    @Override
    public Donaciones save(Donaciones donacion) {
        return donacionesRepository.save(donacion);
    }

    @Override
    public void deleteById(Long id) {
        donacionesRepository.deleteById(id);
    }

    @Override
    public Optional<Donaciones> update(Long id, Donaciones donacionDetalles) {
        Optional<Donaciones> donacionOptional = donacionesRepository.findById(id);
        if (donacionOptional.isPresent()) {
            Donaciones donacionActualizada = donacionOptional.get();
            donacionActualizada.setFecha(donacionDetalles.getFecha());
            donacionActualizada.setCantidad_donada(donacionDetalles.getCantidad_donada());
            donacionActualizada.setUsuario(donacionDetalles.getUsuario()); // Permite actualizar el usuario
            donacionesRepository.save(donacionActualizada);
            return Optional.of(donacionActualizada);
        } else {
            return Optional.empty();
        }
    }
}//Cierre de clase service
