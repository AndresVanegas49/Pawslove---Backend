package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.repository.IusuariosRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IusuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Clase de servicio para manejar la lógica de negocio de Usuarios
@Service
public class UsuariosService implements IusuariosService {

    // Inyección del repositorio
    private final IusuariosRepository usuariosRepository;

    // Constructor para la inyección de dependencias
    @Autowired
    public UsuariosService(IusuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    // Crear un usuario
    @Override
    public Usuarios save(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    // Obtener todos los usuarios
    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    // Obtener un usuario por ID
    @Override
    public Optional<Usuarios> findById(Long id) {
        return usuariosRepository.findById(id);
    }

    // Eliminar un usuario por ID
    @Override
    public void deleteById(Long id) {
        usuariosRepository.deleteById(id);
    }

    // Buscar usuario por email (usando metodo de repositorio)
    public Usuarios buscarPorEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuarios> update(Long id, Usuarios usuarioDetails) {
        return usuariosRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNombre(usuarioDetails.getNombre());
                    usuarioExistente.setApellido(usuarioDetails.getApellido());
                    usuarioExistente.setDireccion(usuarioDetails.getDireccion());
                    usuarioExistente.setEmail(usuarioDetails.getEmail());
                    usuarioExistente.setTelefono(usuarioDetails.getTelefono());
                    usuarioExistente.setPassword(usuarioDetails.getPassword());
                    usuarioExistente.setEstado(usuarioDetails.getEstado());
                    return usuariosRepository.save(usuarioExistente);
                });
    }
}
