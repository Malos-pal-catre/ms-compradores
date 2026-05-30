package com.pesquera.compradores.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrdenCompraResponseDTO {
    private Long id;
    private Long compradorId;
    private String nombreComprador;
    private String especie;
    private Double precioMaximo;
    private Double kilosMaximos;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaEjecucion;
    private Long subastaId;
}
