package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Categoria;
import com.Pawslove.PawsloveV1.repository.IcategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final IcategoriaRepository repo;

    public CategoriaController(IcategoriaRepository repo) {
        this.repo = repo;
    }

    // GET /api/categorias
    @GetMapping
    public List<Categoria> listar() {
        return repo.findAll();
    }

    // GET /api/categorias/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtener(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/categorias
    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria body) {
        body.setId(null); // Ignorar id entrante
        Categoria guardada = repo.save(body);
        return ResponseEntity
                .created(URI.create("/api/categorias/" + guardada.getId()))
                .body(guardada);
    }

    // PUT /api/categorias/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id,
                                                @Valid @RequestBody Categoria body) {
        return repo.findById(id)
                .map(actual -> {
                    actual.setNombre(body.getNombre());
                    actual.setDescripcion(body.getDescripcion());
                    Categoria actualizado = repo.save(actual);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/categorias/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}