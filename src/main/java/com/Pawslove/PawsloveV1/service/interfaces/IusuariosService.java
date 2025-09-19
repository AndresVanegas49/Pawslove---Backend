package com.Pawslove.PawsloveV1.service.interfaces;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IusuariosService extends IgenericService<Usuarios, Long>{
    // Crear o actualizar un usuario
    Usuarios guardarUsuario(Usuarios usuario);

    // Obtener todos los usuarios
    List<Usuarios> obtenerTodosLosUsuarios();

    // Obtener un usuario por ID
    Optional<Usuarios> obtenerUsuarioPorId(Long id);

    // Eliminar un usuario por ID
    void eliminarUsuario(Long id);

    // Buscar usuario por email (usando metodo de repositorio)
    Usuarios buscarPorEmail(String email);

    UserDetails loadUserByUsername(String email);
}
