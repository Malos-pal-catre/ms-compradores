package com.pesquera.compradores.dto;

import lombok.Data;

@Data
public class CompradorResponseDTO {
    private Long id;
    private String nombre;
    private String rut;
    private String email;
    private String telefono;
    private String tipoNegocio;
    private Boolean activo;
}
