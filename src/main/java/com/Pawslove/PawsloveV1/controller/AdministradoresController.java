package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Administradores;
import com.Pawslove.PawsloveV1.service.interfaces.IadministradoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradoresController {
    private final IadministradoresService administradoresService;

    @Autowired
    public AdministradoresController(IadministradoresService administradoresService) {
        this.administradoresService = administradoresService;
    }

    @GetMapping
    public List<Administradores> getAllAdministradores() {
        return administradoresService.findAll();
    }

    @GetMapping("/{id}")
    public Administradores getAdministradorById(@PathVariable Long id) {
        return administradoresService.findById(id).orElse(null);
    }

    @PostMapping("/crearAdmin")
    public Administradores createAdministrador(@RequestBody Administradores administrador) {
        return administradoresService.save(administrador);
    }

    @DeleteMapping("/eliminarAdmin/{id}")
    public void deleteAdministrador(@PathVariable Long id) {
        administradoresService.deleteById(id);
    }

    @PutMapping("/actualizarAdmin/{id}")
    public Administradores updateAdministrador(@PathVariable Long id, @RequestBody Administradores administradorDetalles) {
        return administradoresService.update(id, administradorDetalles).orElse(null);
    }

}//Cierre de controller
