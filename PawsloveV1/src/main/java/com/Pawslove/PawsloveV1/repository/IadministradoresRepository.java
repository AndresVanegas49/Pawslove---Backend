package com.Pawslove.PawsloveV1.repository;
import com.Pawslove.PawsloveV1.modelo.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IadministradoresRepository extends JpaRepository<Administradores, Long> {

}