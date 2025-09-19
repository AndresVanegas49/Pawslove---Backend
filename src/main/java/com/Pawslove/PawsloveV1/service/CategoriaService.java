package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Categoria;
import com.Pawslove.PawsloveV1.repository.IcategoriaRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IcategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements IcategoriaService {

    private final IcategoriaRepository categoriaRepository;

    public CategoriaService(IcategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> update(Long id, Categoria categoriaDetalles) {
        return categoriaRepository.findById(id).map(categoriaExistente -> {
            categoriaExistente.setNombre(categoriaDetalles.getNombre());
            return categoriaRepository.save(categoriaExistente);
        });
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
