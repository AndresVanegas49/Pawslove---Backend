package com.Pawslove.PawsloveV1.controller;


import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.service.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//* Controlador para gestionar las operaciones relacionadas con los usuarios */
@RestController
public class UsuariosController {

    private final UsuariosService usuariosService;

    //Inyección de dependencias a través del constructor
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // Crear un usuario
    @PostMapping
    public ResponseEntity<Usuarios>crearUsuario(@RequestBody Usuarios usuario){ //@RequestBody para mapear el cuerpo de la solicitud al objeto usuario
        Usuarios nuevoUsuario = usuariosService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario); // Devuelve el usuario creado con un estado 200 OK
    }

    // Listar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> obtenerUsuario() { //
        return ResponseEntity.ok(usuariosService.obtenerTodosLosUsuarios()); // Devuelve la lista de usuarios con un estado 200 OK
    }

    // Obtener usaurio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable Long id){ //@PathVariable para obtener el ID de la URL
        Optional<Usuarios> usuario = usuariosService.obtenerUsuarioPorId(id); // Optional es una clase contenedor que puede o no contener un valor no nulo
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por email
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
