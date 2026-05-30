package com.pesquera.compradores.controller;

import com.pesquera.compradores.dto.CompradorRequestDTO;
import com.pesquera.compradores.model.Comprador;
import com.pesquera.compradores.service.CompradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compradores")
@RequiredArgsConstructor
public class CompradorController {

    private final CompradorService compradorService;

    @PostMapping
    public ResponseEntity<Comprador> crearComprador(@Valid @RequestBody CompradorRequestDTO dto) {
        Comprador comprador = new Comprador();
        comprador.setNombre(dto.getNombre());
        comprador.setRut(dto.getRut());
        comprador.setEmail(dto.getEmail());
        comprador.setTelefono(dto.getTelefono());
        comprador.setTipoNegocio(dto.getTipoNegocio());
        return ResponseEntity.status(HttpStatus.CREATED).body(compradorService.crearComprador(comprador));
    }

    @GetMapping
    public ResponseEntity<List<Comprador>> obtenerTodos() {
        return ResponseEntity.ok(compradorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comprador> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(compradorService.obtenerPorId(id));
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Comprador> obtenerPorRut(@PathVariable String rut) {
        return ResponseEntity.ok(compradorService.obtenerPorRut(rut));
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Comprador>> obtenerActivos() {
        return ResponseEntity.ok(compradorService.obtenerActivos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comprador> actualizarComprador(@PathVariable Long id, @Valid @RequestBody CompradorRequestDTO dto) {
        Comprador comprador = new Comprador();
        comprador.setNombre(dto.getNombre());
        comprador.setTelefono(dto.getTelefono());
        comprador.setTipoNegocio(dto.getTipoNegocio());
        return ResponseEntity.ok(compradorService.actualizarComprador(id, comprador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comprador> desactivarComprador(@PathVariable Long id) {
        return ResponseEntity.ok(compradorService.desactivarComprador(id));
    }
}