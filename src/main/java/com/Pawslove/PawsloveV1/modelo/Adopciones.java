package com.Pawslove.PawsloveV1.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adopciones")
public class Adopciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adopcion")
    private Long id;

    private LocalDate fecha;
    @Column(name = "documentoAdopcion")
    private String documento;

    @OneToOne
    @JsonBackReference("mascotas_adopciones")
    @JoinColumn(name = "id_mascota", unique = true, nullable = false)
    private Mascotas mascota;

    @ManyToOne
    @JsonBackReference("usuarios_adopciones")
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public Mascotas getMascota() { return mascota; }
    public void setMascota(Mascotas mascota) { this.mascota = mascota; }

    public Usuarios getUsuario() { return usuario; }
    public void setUsuario(Usuarios usuario) { this.usuario = usuario; }
}
