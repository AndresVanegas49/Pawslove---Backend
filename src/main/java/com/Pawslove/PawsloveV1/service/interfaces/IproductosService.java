package com.Pawslove.PawsloveV1.service.interfaces;

import com.Pawslove.PawsloveV1.modelo.Productos;

import java.util.List;

public interface IproductosService extends IgenericService<Productos, Long>{
    List<Productos> findByNombre(String nombre);
}
