package com.Pawslove.PawsloveV1.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;


@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false) //Unique para que no se repita y NotNull para que no sea nulo
    private String nombre;

    @Column(unique = true, nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String direccion;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String constrasena;

    @Column
    private String estado;

    //Relaciones con otras tablas

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adopciones> adopciones;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donaciones> donaciones;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordenes> ordenes;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getConstrasena() {
        return constrasena;
    }

    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getters y Setters para las relaciones

    public List<Adopciones> getAdopciones() {
        return adopciones;
    }
    public void setAdopciones(List<Adopciones> adopciones) {
        this.adopciones = adopciones;
    }
    public List<Donaciones> getDonaciones() {
        return donaciones;
    }
    public void setDonaciones(List<Donaciones> donaciones) {
        this.donaciones = donaciones;
    }
    public List<Ordenes> getOrdenes() {
        return ordenes;
    }
    public void setOrdenes(List<Ordenes> ordenes) {
        this.ordenes = ordenes;
    }
}
