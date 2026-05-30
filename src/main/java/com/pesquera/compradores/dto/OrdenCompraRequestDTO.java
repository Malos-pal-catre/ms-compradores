package com.pesquera.compradores.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrdenCompraRequestDTO {

    @NotNull(message = "El id del comprador es obligatorio")
    private Long compradorId;

    @NotBlank(message = "La especie es obligatoria")
    private String especie;

    @NotNull(message = "El precio máximo es obligatorio")
    @Positive(message = "El precio máximo debe ser mayor a 0")
    private Double precioMaximo;

    @NotNull(message = "Los kilos máximos son obligatorios")
    @Positive(message = "Los kilos máximos deben ser mayor a 0")
    private Double kilosMaximos;
}