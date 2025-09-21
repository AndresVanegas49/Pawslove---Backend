package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Categoria;
import com.Pawslove.PawsloveV1.repository.IcategoriaRepository;
import com.Pawslove.PawsloveV1.service.CategoriaService;
import com.Pawslove.PawsloveV1.service.interfaces.IcategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService repo;

    @Autowired
    public CategoriaController(CategoriaService repo) {
        this.repo = repo;
    }

    // GET /categorias
    @GetMapping
    public List<Categoria> listar() {
        return repo.findAll();
    }

    // GET /categorias/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtener(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /categorias
    @PostMapping("/crearCategoria")
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria body) {
        body.setId(null); // Ignorar id entrante
        Categoria guardada = repo.save(body);
        return ResponseEntity
                .created(URI.create("/api/categorias/" + guardada.getId()))
                .body(guardada);
    }

    // PUT /categorias/{id}
    @PutMapping("/auctualizarCategoria/{id}")
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
    @DeleteMapping("/eliminarCategoria/{id}")
    public void deleteCategoria(@PathVariable Long id){
        repo.deleteById(id);
    }
}