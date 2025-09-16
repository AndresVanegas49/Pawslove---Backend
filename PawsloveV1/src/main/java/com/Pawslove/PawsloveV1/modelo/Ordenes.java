package com.Pawslove.PawsloveV1.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;
    @Column(nullable = false)
    private LocalDateTime fecha;
    @Column(nullable = false)
    private int cantidad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference("orden_id_usuario")
    private Usuarios usuario;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonBackReference("orden_id_producto")
    private Productos producto;

    public Ordenes() {}

    public Ordenes(LocalDateTime fecha, int cantidad, Usuarios usuario, Productos producto) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.producto = producto;
    }

    public Ordenes(Long id_orden, LocalDateTime fecha, int cantidad, Usuarios usuario, Productos producto) {
        this.id_orden = id_orden;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.producto = producto;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}//Cierre de clase
