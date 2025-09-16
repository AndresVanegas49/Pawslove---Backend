package com.Pawslove.PawsloveV1.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;
    private LocalDateTime fecha;
    private int cantidad;
    @ManyToOne
    @JsonBackReference("orden_id_usuario")
    private Long id_usuario;
    @ManyToOne
    @JsonBackReference("orden_id_producto")
    private Long id_producto;

    public Ordenes() {}

    public Ordenes(LocalDateTime fecha, int cantidad, Long id_usuario, Long id_producto) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public Ordenes(Long id_orden, LocalDateTime fecha, int cantidad, Long id_usuario, Long id_producto) {
        this.id_orden = id_orden;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public Long getId_orden() {
        return id_orden;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}//Cierre de clase
