package com.Pawslove.PawsloveV1.controller;


import com.Pawslove.PawsloveV1.JWT.JwtUtil;
import com.Pawslove.PawsloveV1.dto.usuarioDto;
import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuarios usuarios){
        usuariosService.guardarUsuario(usuarios);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/loginConDTO")
    public ResponseEntity<String> loginConDTO(@RequestBody usuarioDto usuarioDto) {
        Usuarios usuarios = usuariosService.buscarPorEmail(usuarioDto.getEmail());
        if (usuarios != null && passwordEncoder.matches(usuarioDto.getPassword(), usuarios.getPassword())) {
            String token = jwtUtil.generateToken(usuarios.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    @GetMapping("/resource")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
}
