package com.tecMatch.TecMatch.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Ram{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer capacidad;
    private Integer velocidad;
    private Boolean ECC;
    private String regBuf;
    private Integer ancho_banda;

    @OneToOne
    @JoinColumn(name = "pieza_id")
    private Pieza pieza;
}
