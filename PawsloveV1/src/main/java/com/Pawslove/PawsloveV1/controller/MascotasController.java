package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Mascotas;
import com.Pawslove.PawsloveV1.service.ImascotasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotasController {

    private final ImascotasService mascotaService;

    public MascotasController(ImascotasService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<Mascotas> listarMascotas() {
        return mascotaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascotas> obtenerMascota(@PathVariable Long id) {
        return mascotaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mascotas crearMascota(@RequestBody Mascotas mascota) {
        return mascotaService.save(mascota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascotas> actualizarMascota(@PathVariable Long id, @RequestBody Mascotas mascota) {
        return mascotaService.findById(id)
                .map(m -> {
                    mascota.setIdMascota(id);
                    return ResponseEntity.ok(mascotaService.save(mascota));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable Long id) {
        mascotaService.deleteById(id);
    }
}
