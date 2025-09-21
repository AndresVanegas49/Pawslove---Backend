package com.Pawslove.PawsloveV1.controller;


import com.Pawslove.PawsloveV1.modelo.Productos;
import com.Pawslove.PawsloveV1.service.ProductosService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @PostMapping
    public ResponseEntity<Productos> crearProducto(@RequestBody Productos productos){
        Productos nuevoProducto = productosService.save(productos);
        return ResponseEntity.ok(nuevoProducto);
    }

    @GetMapping
    public ResponseEntity<List<Productos>> obtenerProductos() {
        return ResponseEntity.ok(productosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtenerProductoPorId(@PathVariable Long id) {
        return productosService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Productos>> buscarPorNombre(@RequestParam String nombre) {
        List<Productos> productos = productosService.findByNombre(nombre);
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(productos);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Long id, @RequestBody Productos productos) {
        return productosService.update(id, productos)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
