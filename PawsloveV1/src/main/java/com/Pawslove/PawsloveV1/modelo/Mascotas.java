package com.Pawslove.PawsloveV1.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;

    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;

    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    private Adopciones adopcion;

    // Getters y setters
    public Long getIdMascota() { return idMascota; }
    public void setIdMascota(Long idMascota) { this.idMascota = idMascota; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public Adopciones getAdopcion() { return adopcion; }
    public void setAdopcion(Adopciones adopcion) { this.adopcion = adopcion; }
}
