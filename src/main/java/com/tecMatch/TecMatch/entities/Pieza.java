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
public class Pieza {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    private String modelo;
    private Float precio;
    private Float voltaje;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "fabricante")
    private Fabricante fabricante;

    @ManyToOne
    @JoinColumn(name = "socket")
    private Socket socket;

    @OneToMany(mappedBy = "pieza",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<PiezaDeseada> piezasDeseadas;

    @OneToMany(mappedBy = "pieza",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Review> reviews;

    @OneToMany(mappedBy = "pieza",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<PiezaEnListaConstruccion> piezasEnListaConstruccion;
}
