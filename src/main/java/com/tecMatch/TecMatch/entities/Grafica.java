package com.tecMatch.TecMatch.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Grafica{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer nucleos;
    private Float frecuencia;
    private Integer memoria;
    private String interfaz_memoria;
    private Integer ancho_banda;
    private Integer ventiladores;
    private Integer cant_HDMI;
    private Integer cant_DisplayPorts;

    @OneToOne
    @JoinColumn(name = "pieza_id")
    private Pieza pieza;
}
