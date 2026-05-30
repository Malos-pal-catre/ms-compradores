package com.pesquera.compradores.controller;

import com.pesquera.compradores.dto.CompradorMapper;
import com.pesquera.compradores.dto.CompradorRequestDTO;
import com.pesquera.compradores.dto.CompradorResponseDTO;
import com.pesquera.compradores.model.Comprador;
import com.pesquera.compradores.service.CompradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/compradores")
@RequiredArgsConstructor
public class CompradorController {

    private final CompradorService compradorService;

    @PostMapping
    public ResponseEntity<CompradorResponseDTO> crearComprador(@Valid @RequestBody CompradorRequestDTO dto) {
        Comprador comprador = CompradorMapper.toEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(CompradorMapper.toDTO(compradorService.crearComprador(comprador)));
    }

    @GetMapping
    public ResponseEntity<List<CompradorResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(compradorService.obtenerTodos().stream().map(CompradorMapper::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompradorResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(CompradorMapper.toDTO(compradorService.obtenerPorId(id)));
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<CompradorResponseDTO> obtenerPorRut(@PathVariable String rut) {
        return ResponseEntity.ok(CompradorMapper.toDTO(compradorService.obtenerPorRut(rut)));
    }

    @GetMapping("/activos")
    public ResponseEntity<List<CompradorResponseDTO>> obtenerActivos() {
        return ResponseEntity.ok(compradorService.obtenerActivos().stream().map(CompradorMapper::toDTO).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompradorResponseDTO> actualizarComprador(@PathVariable Long id, @Valid @RequestBody CompradorRequestDTO dto) {
        Comprador comprador = CompradorMapper.toEntity(dto);
        return ResponseEntity.ok(CompradorMapper.toDTO(compradorService.actualizarComprador(id, comprador)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompradorResponseDTO> desactivarComprador(@PathVariable Long id) {
        return ResponseEntity.ok(CompradorMapper.toDTO(compradorService.desactivarComprador(id)));
    }
}
