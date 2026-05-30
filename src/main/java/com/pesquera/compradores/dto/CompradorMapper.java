package com.pesquera.compradores.dto;

import com.pesquera.compradores.model.Comprador;

public class CompradorMapper {

    public static CompradorResponseDTO toDTO(Comprador comprador) {
        CompradorResponseDTO dto = new CompradorResponseDTO();
        dto.setId(comprador.getId());
        dto.setNombre(comprador.getNombre());
        dto.setRut(comprador.getRut());
        dto.setEmail(comprador.getEmail());
        dto.setTelefono(comprador.getTelefono());
        dto.setTipoNegocio(comprador.getTipoNegocio());
        dto.setActivo(comprador.getActivo());
        return dto;
    }

    public static Comprador toEntity(CompradorRequestDTO dto) {
        Comprador comprador = new Comprador();
        comprador.setNombre(dto.getNombre());
        comprador.setRut(dto.getRut());
        comprador.setEmail(dto.getEmail());
        comprador.setTelefono(dto.getTelefono());
        comprador.setTipoNegocio(dto.getTipoNegocio());
        return comprador;
    }
}
