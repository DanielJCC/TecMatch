package com.tecMatch.TecMatch.mappers;

import com.tecMatch.TecMatch.dto.socket.SocketDto;
import com.tecMatch.TecMatch.dto.socket.SocketToSaveDto;
import com.tecMatch.TecMatch.entities.Socket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SocketMapper {
    Socket DtoToEntity(SocketDto socketDto);
    SocketDto EntityToDto(Socket socket);
    Socket ToSaveDtoToEntity(SocketToSaveDto socketToSaveDto);
}
