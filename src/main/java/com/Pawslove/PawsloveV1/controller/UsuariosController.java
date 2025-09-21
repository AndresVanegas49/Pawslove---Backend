package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios") //
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // Crear un usuario
    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuariosService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Listar todos los usuarios - GET /usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> obtenerUsuario() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    // Obtener usuario por ID - GET /usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuarios> usuario = usuariosService.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar usuario por ID - DELETE /usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuariosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por email - GET /usuarios/buscarPorEmail?email=valor
    @GetMapping("/buscarPorEmail")
    public ResponseEntity<Usuarios> buscarPorEmail(@RequestParam String email) {
        Usuarios usuario = usuariosService.buscarPorEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar usuario por ID - PUT /usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarioDetalles) {
        return usuariosService.update(id, usuarioDetalles)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}