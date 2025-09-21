package com.Pawslove.PawsloveV1.service;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import com.Pawslove.PawsloveV1.repository.IusuariosRepository;
import com.Pawslove.PawsloveV1.service.interfaces.IusuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IusuariosService, UserDetailsService {

    private final IusuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuariosService(IusuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> findById(Long id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuarios save(Usuarios usuario) {
        // Codificar la contraseña antes de guardar un nuevo usuario
        if (usuario.getId() == null) { // Asumimos que es nuevo si no tiene ID
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        return usuariosRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuariosRepository.deleteById(id);
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
                    // Opcional: permitir actualizar la contraseña
                    if (usuarioDetails.getPassword() != null && !usuarioDetails.getPassword().isEmpty()) {
                        usuarioExistente.setPassword(passwordEncoder.encode(usuarioDetails.getPassword()));
                    }
                    usuarioExistente.setEstado(usuarioDetails.getEstado());
                    return usuariosRepository.save(usuarioExistente);
                });
    }

    public Usuarios buscarPorEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email: " + email);
        }
        return User.withUsername(usuario.getEmail())
                .password(usuario.getPassword())
                .authorities("USER") // Roles o permisos del usuario
                .build();
    }
}
