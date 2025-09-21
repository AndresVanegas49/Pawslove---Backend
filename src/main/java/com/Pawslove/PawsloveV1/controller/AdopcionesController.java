package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Adopciones;
import com.Pawslove.PawsloveV1.service.interfaces.IadopcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
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
        // Es una buena práctica verificar si la entidad existe antes de intentar borrarla.
        if (!adopcionService.findById(id).isPresent()) {
            // Si no existe, devolvemos un 404 Not Found.
            return new ResponseEntity<>("No se encontró la adopción con ID: " + id, HttpStatus.NOT_FOUND);
        }
        try {
            adopcionService.deleteById(id);
            // Si la eliminación es exitosa, devolvemos un 200 OK.
            return ResponseEntity.ok("La adopción fue eliminada del sistema.");
        } catch (DataIntegrityViolationException e) {
            // Esta excepción es común cuando se viola una restricción de clave externa.
            // Significa que otro registro en la base de datos depende de esta adopción.
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("La adopción no puede ser eliminada porque está referenciada por otros registros.");
        }
    }
}
