package com.tecMatch.TecMatch.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Placa{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer cantidadDIMMs;
    private Integer alimentacion;
    private Integer EPS;
    private Integer puertosVentilador;
    private Boolean pump;
    private Boolean PCLe_M2;
    private Integer puertosSATA;
    private Integer cantidadUSBTipo3;
    private Integer cantidadUSBTipo2;
    private Integer cantidadUSBC;
    private Integer cantidadHDAudio;
    private Integer cantidadHDMI;

    @OneToOne
    @JoinColumn(name = "pieza_id")
    private Pieza pieza;
}
