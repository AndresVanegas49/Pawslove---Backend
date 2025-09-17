package com.Pawslove.PawsloveV1.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adopciones")
public class Adopciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdopcion;

    private LocalDate fecha;
    private String documento;

    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    private Mascotas mascota;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    // Getters y setters
    public Long getIdAdopcion() { return idAdopcion; }
    public void setIdAdopcion(Long idAdopcion) { this.idAdopcion = idAdopcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public Mascotas getMascota() { return mascota; }
    public void setMascota(Mascotas mascota) { this.mascota = mascota; }

    public Usuarios getUsuario() { return usuario; }
    public void setUsuario(Usuarios usuario) { this.usuario = usuario; }
}

