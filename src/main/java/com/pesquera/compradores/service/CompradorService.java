package com.pesquera.compradores.service;

import com.pesquera.compradores.model.Comprador;
import com.pesquera.compradores.repository.CompradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompradorService {

    private final CompradorRepository compradorRepository;

    public Comprador crearComprador(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    public List<Comprador> obtenerTodos() {
        return compradorRepository.findAll();
    }

    public Comprador obtenerPorId(Long id) {
        return compradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comprador no encontrado con id: " + id));
    }

    public Comprador obtenerPorRut(String rut) {
        return compradorRepository.findByRut(rut)
                .orElseThrow(() -> new RuntimeException("Comprador no encontrado con rut: " + rut));
    }

    public List<Comprador> obtenerActivos() {
        return compradorRepository.findByActivo(true);
    }

    public Comprador actualizarComprador(Long id, Comprador comprador) {
        Comprador existente = obtenerPorId(id);
        existente.setNombre(comprador.getNombre());
        existente.setTelefono(comprador.getTelefono());
        existente.setTipoNegocio(comprador.getTipoNegocio());
        return compradorRepository.save(existente);
    }

    public Comprador desactivarComprador(Long id) {
        Comprador comprador = obtenerPorId(id);
        comprador.setActivo(false);
        return compradorRepository.save(comprador);
    }
}