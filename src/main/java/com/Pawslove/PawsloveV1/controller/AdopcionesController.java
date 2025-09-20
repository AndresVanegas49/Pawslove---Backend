package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Adopciones;
import com.Pawslove.PawsloveV1.service.interfaces.IadopcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopciones")
public class AdopcionesController {

    private final IadopcionesService adopcionService;

    @Autowired
    public AdopcionesController(IadopcionesService adopcionService) {
        this.adopcionService = adopcionService;
    }

    @GetMapping
    public List<Adopciones> listarAdopciones() {
        return adopcionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adopciones> obtenerAdopcion(@PathVariable Long id) {
        return adopcionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/procesoAdopcion")
    public Adopciones crearAdopcion(@RequestBody Adopciones adopcion) {
        return adopcionService.save(adopcion);
    }

    @PutMapping("/actualizarAdopcion/{id}")
    public ResponseEntity<Adopciones> actualizarAdopcion(@PathVariable Long id, @RequestBody Adopciones adopcionDetalles) {
        return adopcionService.update(id, adopcionDetalles)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminarAdopcion/{id}")
    public ResponseEntity<String> deleteAdopcion(@PathVariable Long id) {
        adopcionService.deleteById(id);
        if (adopcionService.findById(id).isPresent()){
            return ResponseEntity.ok("El elemento no pudo ser borrado, está relacionado con persona o mascota.");
        }else{
            return ResponseEntity.ok("El elemento fue eliminado del sistema.");
        }
    }
}
