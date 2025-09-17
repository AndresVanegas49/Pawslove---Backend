package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.repository.IusuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio de Usuarios
@Service
public class UsuariosService {

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
}
