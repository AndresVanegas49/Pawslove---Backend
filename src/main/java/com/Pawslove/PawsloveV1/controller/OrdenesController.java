package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Ordenes;
import com.Pawslove.PawsloveV1.service.OrdeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenesController {
    private OrdeneService ordeneService;

    @Autowired
    public OrdenesController(OrdeneService ordeneService) {
        this.ordeneService = ordeneService;
    }

    @GetMapping
    public List<Ordenes> getAllOrdenes(){
        return ordeneService.findAll();
    }

    @GetMapping("/{id}")
    public Ordenes getOrdenById(@PathVariable Long id){
        return ordeneService.findById(id).orElse(null);
    }

    @PostMapping("/crearOrden")
    public Ordenes createOrden(@RequestBody Ordenes orden){
        return ordeneService.save(orden);
    }

    @DeleteMapping("/eliminarOrden/{id}")
    public void deleteOrden(@PathVariable Long id){
        ordeneService.deleteById(id);
    }

    @PutMapping("/actualizarOrden/{id}")
    public Ordenes updateOrden(@PathVariable Long id, @RequestBody Ordenes ordenDetalles){
        return ordeneService.update(id, ordenDetalles).orElse(null);
    }

}//Cierre de clase controller
