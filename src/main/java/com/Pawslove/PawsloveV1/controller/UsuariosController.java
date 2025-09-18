package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.service.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios") //
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // Crear un usuario
    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuariosService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Listar todos los usuarios - GET /usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> obtenerUsuario() {
        return ResponseEntity.ok(usuariosService.obtenerTodosLosUsuarios());
    }

    // Obtener usuario por ID - GET /usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuarios> usuario = usuariosService.obtenerUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar usuario por ID - DELETE /usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuario(id);
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
}