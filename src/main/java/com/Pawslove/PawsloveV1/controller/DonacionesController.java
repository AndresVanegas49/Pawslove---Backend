package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Donaciones;
import com.Pawslove.PawsloveV1.service.DonacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donaciones")
public class DonacionesController {
    private DonacionesService donacionesService;

    @Autowired
    public DonacionesController(DonacionesService donacionesService) {
        this.donacionesService = donacionesService;
    }

    @GetMapping
    public List<Donaciones> getAllDonaciones() {
        return donacionesService.findAll();
    }

    @GetMapping("/{id}")
    public Donaciones getDonacionById(@PathVariable Long id) {
        return donacionesService.findById(id).orElse(null);
    }

    @PostMapping("/donar")
    public Donaciones createDonacion(@RequestBody Donaciones donacion) {
        return donacionesService.save(donacion);
    }

    @DeleteMapping("/eliminarDonacion/{id}")
    public void deleteDonacion(@PathVariable Long id) {
        donacionesService.deleteById(id);
    }

    @PutMapping("/actualizarDonacion/{id}")
    public Donaciones updateDonacion(@PathVariable Long id, @RequestBody Donaciones donacionDetalles) {
        return donacionesService.update(id, donacionDetalles).orElse(null);
    }

}//Cierre de clase controller
