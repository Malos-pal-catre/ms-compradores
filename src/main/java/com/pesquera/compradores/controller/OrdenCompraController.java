package com.pesquera.compradores.controller;

import com.pesquera.compradores.dto.OrdenCompraRequestDTO;
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

@RestController
@RequestMapping("/api/ordenes")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final CompradorService compradorService;

    @PostMapping
    public ResponseEntity<OrdenCompra> crearOrden(@Valid @RequestBody OrdenCompraRequestDTO dto) {
        Comprador comprador = compradorService.obtenerPorId(dto.getCompradorId());
        OrdenCompra orden = new OrdenCompra();
        orden.setComprador(comprador);
        orden.setEspecie(dto.getEspecie());
        orden.setPrecioMaximo(dto.getPrecioMaximo());
        orden.setKilosMaximos(dto.getKilosMaximos());
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCompraService.crearOrden(orden));
    }

    @GetMapping
    public ResponseEntity<List<OrdenCompra>> obtenerTodas() {
        return ResponseEntity.ok(ordenCompraService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompra> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorId(id));
    }

    @GetMapping("/comprador/{compradorId}")
    public ResponseEntity<List<OrdenCompra>> obtenerPorComprador(@PathVariable Long compradorId) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorComprador(compradorId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<OrdenCompra>> obtenerPorEstado(@PathVariable EstadoOrden estado) {
        return ResponseEntity.ok(ordenCompraService.obtenerPorEstado(estado));
    }

    @PutMapping("/{id}/ejecutar")
    public ResponseEntity<OrdenCompra> ejecutarOrden(@PathVariable Long id, @RequestParam Long subastaId) {
        return ResponseEntity.ok(ordenCompraService.ejecutarOrden(id, subastaId));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<OrdenCompra> cancelarOrden(@PathVariable Long id) {
        return ResponseEntity.ok(ordenCompraService.cancelarOrden(id));
    }
}