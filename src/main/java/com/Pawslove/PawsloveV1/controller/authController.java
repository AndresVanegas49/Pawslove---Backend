package com.Pawslove.PawsloveV1.controller;

import com.Pawslove.PawsloveV1.JWT.JwtUtil;
import com.Pawslove.PawsloveV1.dto.usuarioDto;
import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuarios usuario) {
        usuariosService.save(usuario);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/loginConDTO")
    public ResponseEntity<String> loginConDTO(@RequestBody usuarioDto usuarioDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(), usuarioDto.getPassword())
            );
        } catch (AuthenticationException e) {
            // Capturamos cualquier excepción de autenticación y devolvemos 401
            return ResponseEntity.status(401).body("Credenciales inválidas o usuario no encontrado");
        }

        final UserDetails userDetails = usuariosService.loadUserByUsername(usuarioDto.getEmail());
        final String token = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(token);
    }

    @GetMapping("/resource")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
}
