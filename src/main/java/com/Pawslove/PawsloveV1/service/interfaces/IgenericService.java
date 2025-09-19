package com.Pawslove.PawsloveV1.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IgenericService<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
    Optional<T> update(ID id, T entity);
}
