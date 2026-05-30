package com.pesquera.compradores.dto;

import com.pesquera.compradores.model.OrdenCompra;

public class OrdenCompraMapper {

    public static OrdenCompraResponseDTO toDTO(OrdenCompra orden) {
        OrdenCompraResponseDTO dto = new OrdenCompraResponseDTO();
        dto.setId(orden.getId());
        dto.setCompradorId(orden.getComprador().getId());
        dto.setNombreComprador(orden.getComprador().getNombre());
        dto.setEspecie(orden.getEspecie());
        dto.setPrecioMaximo(orden.getPrecioMaximo());
        dto.setKilosMaximos(orden.getKilosMaximos());
        dto.setEstado(orden.getEstado().name());
        dto.setFechaCreacion(orden.getFechaCreacion());
        dto.setFechaEjecucion(orden.getFechaEjecucion());
        dto.setSubastaId(orden.getSubastaId());
        return dto;
    }

    public static OrdenCompra toEntity(OrdenCompraRequestDTO dto) {
        OrdenCompra orden = new OrdenCompra();
        orden.setEspecie(dto.getEspecie());
        orden.setPrecioMaximo(dto.getPrecioMaximo());
        orden.setKilosMaximos(dto.getKilosMaximos());
        return orden;
    }
}
