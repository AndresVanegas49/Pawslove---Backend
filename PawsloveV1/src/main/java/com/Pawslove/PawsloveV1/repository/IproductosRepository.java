package com.Pawslove.PawsloveV1.repository;


import com.Pawslove.PawsloveV1.modelo.Categoria;
import com.Pawslove.PawsloveV1.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//* Interface para el repositorio de Productos
@Repository
public interface IproductosRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByNombre(String nombre);
}
