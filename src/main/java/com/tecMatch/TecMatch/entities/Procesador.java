package com.tecMatch.TecMatch.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Procesador{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer nucleos;
    private Integer hilos;
    private Float frecuencia;
    private String cache;
    private String integrado;

    @OneToOne
    @JoinColumn(name = "pieza_id")
    private Pieza pieza;
}
