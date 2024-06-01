package com.tecMatch.TecMatch.dto.ram;

import com.tecMatch.TecMatch.dto.fabricante.FabricanteDto;
import com.tecMatch.TecMatch.dto.pieza.PiezaDto;
import com.tecMatch.TecMatch.dto.socket.SocketDto;

public record RamToSaveDto(
        Integer capacidad,
        Integer velocidad,
        Boolean ECC,
        String regBuf,
        Integer ancho_banda,
        PiezaDto pieza
) {
}
