package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.repository.IusuariosRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IusuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio de Usuarios
@Service
public class UsuariosService implements IusuariosService {

    @Autowired
    private IusuariosRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Inyección del repositorio
    private IusuariosRepository usuariosRepository;

    // Constructor para la inyección de dependencias
    public UsuariosService(IusuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // Crear o actualizar un usuario
    public Usuarios guardarUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuarios> obtenerTodosLosUsuarios() {
        return usuariosRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuarios> obtenerUsuarioPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    // Eliminar un usuario por ID
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }

    // Buscar usuario por email (usando metodo de repositorio)
    public Usuarios buscarPorEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

//    public UserDetails loadUserByUsername(String email) {
//        Usuarios usuario = usuariosRepository.findByEmail(email);
//        if (usuario == null) {
//            throw new RuntimeException("Usuario no encontrado");
//        }
//        return org.springframework.security.core.userdetails.User
//                .withUsername(usuario.getEmail())
//                .password(usuario.getPassword())
//                .authorities("USER") // Puedes ajustar los roles según tu lógica
//                .build();
//    }

    @Override
    public List<Usuarios> findAll() {
        return List.of();
    }

    @Override
    public Optional<Usuarios> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Usuarios save(Usuarios entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Usuarios> update(Long aLong, Usuarios entity) {
        return Optional.empty();
    }
}
