package com.Pawslove.PawsloveV1.service;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz genérica para los servicios CRUD.
 * @param <T> La clase de la entidad.
 * @param <ID> El tipo del ID de la entidad (normalmente Long).
 */
public interface IgenericService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    Optional<T> update(ID id, T entity);
    void deleteById(ID id);
}