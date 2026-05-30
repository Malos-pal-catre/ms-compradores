package com.pesquera.compradores.service;

import com.pesquera.compradores.model.OrdenCompra;
import com.pesquera.compradores.model.EstadoOrden;
import com.pesquera.compradores.repository.OrdenCompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;

    public OrdenCompra crearOrden(OrdenCompra orden) {
        orden.setEstado(EstadoOrden.PENDIENTE);
        orden.setFechaCreacion(LocalDateTime.now());
        return ordenCompraRepository.save(orden);
    }

    public List<OrdenCompra> obtenerTodas() {
        return ordenCompraRepository.findAll();
    }

    public OrdenCompra obtenerPorId(Long id) {
        return ordenCompraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada con id: " + id));
    }

    public List<OrdenCompra> obtenerPorComprador(Long compradorId) {
        return ordenCompraRepository.findByCompradorId(compradorId);
    }

    public List<OrdenCompra> obtenerPorEstado(EstadoOrden estado) {
        return ordenCompraRepository.findByEstado(estado);
    }

    public OrdenCompra ejecutarOrden(Long id, Long subastaId) {
        OrdenCompra orden = obtenerPorId(id);
        orden.setEstado(EstadoOrden.EJECUTADA);
        orden.setSubastaId(subastaId);
        orden.setFechaEjecucion(LocalDateTime.now());
        return ordenCompraRepository.save(orden);
    }

    public OrdenCompra cancelarOrden(Long id) {
        OrdenCompra orden = obtenerPorId(id);
        orden.setEstado(EstadoOrden.CANCELADA);
        return ordenCompraRepository.save(orden);
    }
}