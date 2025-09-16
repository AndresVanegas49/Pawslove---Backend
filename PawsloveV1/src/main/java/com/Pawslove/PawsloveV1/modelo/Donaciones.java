package com.Pawslove.PawsloveV1.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Donaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_donacion;
    private double cantidad_donada;
    private LocalDateTime fecha;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference("donaciones_id_usuario")
    private Usuarios usuario;

    public Donaciones() {}

    public Donaciones(double cantidad_donada, LocalDateTime fecha, Usuarios usuario) {
        this.cantidad_donada = cantidad_donada;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Donaciones(Long id_donacion, double cantidad_donada, LocalDateTime fecha, Usuarios usuario) {
        this.id_donacion = id_donacion;
        this.cantidad_donada = cantidad_donada;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Long getId_donacion() {
        return id_donacion;
    }

    public double getCantidad_donada() {
        return cantidad_donada;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setCantidad_donada(double cantidad_donada) {
        this.cantidad_donada = cantidad_donada;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}//Cierre de clase
