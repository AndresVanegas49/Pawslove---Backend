package com.Pawslove.PawsloveV1.repository;

import com.Pawslove.PawsloveV1.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcategoriaRepository extends JpaRepository<Categoria, Long> {

}
