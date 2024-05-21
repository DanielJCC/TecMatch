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
public class Socket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;

    @OneToMany(mappedBy = "socket",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Pieza> piezas;

    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoSocket tipoSocket;
}
