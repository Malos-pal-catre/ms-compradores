package com.pesquera.compradores.controller;

import com.pesquera.compradores.dto.OrdenCompraMapper;
import com.pesquera.compradores.dto.OrdenCompraRequestDTO;
import com.pesquera.compradores.dto.OrdenCompraResponseDTO;
import com.pesquera.compradores.model.Comprador;
import com.pesquera.compradores.model.OrdenCompra;
import com.pesquera.compradores.model.EstadoOrden;
import com.pesquera.compradores.service.CompradorService;
import com.pesquera.compradores.service.OrdenCompraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final CompradorService compradorService;

    @PostMapping
    public ResponseEntity<OrdenCompraResponseDTO> crearOrden(@Valid @RequestBody OrdenCompraRequestDTO dto) {
        Comprador comprador = compradorService.obtenerPorId(dto.getCompradorId());
        OrdenCompra orden = OrdenCompraMapper.toEntity(dto);
        orden.setComprador(comprador);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrdenCompraMapper.toDTO(ordenCompraService.crearOrden(orden)));
    }

    @GetMapping
    public ResponseEntity<List<OrdenCompraResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(ordenCompraService.obtenerTodas().stream().map(OrdenCompraMapper::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompraResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(OrdenCompraMapper.toDTO(ordenCompraService.obtenerPorId(id)));
    }

    @GetMapping("/comprador/{compradorId}")
    public ResponseEntity<List<OrdenCompraResponseDTO>> obtenerPorComprador(@PathVariable Long compradorId) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorComprador(compradorId).stream().map(OrdenCompraMapper::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<OrdenCompraResponseDTO>> obtenerPorEstado(@PathVariable EstadoOrden estado) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorEstado(estado).stream().map(OrdenCompraMapper::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}/ejecutar")
    public ResponseEntity<OrdenCompraResponseDTO> ejecutarOrden(@PathVariable Long id, @RequestParam Long subastaId) {
        return ResponseEntity.ok(OrdenCompraMapper.toDTO(ordenCompraService.ejecutarOrden(id, subastaId)));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<OrdenCompraResponseDTO> cancelarOrden(@PathVariable Long id) {
        return ResponseEntity.ok(OrdenCompraMapper.toDTO(ordenCompraService.cancelarOrden(id)));
    }
}
