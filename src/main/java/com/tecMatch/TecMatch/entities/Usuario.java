package com.tecMatch.TecMatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String correo_electronico;
    private String password;
    private String nombre_usuario;
    private Boolean perm_admin;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<PiezaDeseada> piezasDeseadas;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Review> reviews;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<PiezaEnListaConstruccion> piezasEnListaConstruccion;
}
