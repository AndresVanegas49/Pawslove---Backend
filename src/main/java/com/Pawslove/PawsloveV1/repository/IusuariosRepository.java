package com.Pawslove.PawsloveV1.repository;

import com.Pawslove.PawsloveV1.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IusuariosRepository extends JpaRepository<Usuarios, Long> {

    Usuarios findByEmail(String email);
}
