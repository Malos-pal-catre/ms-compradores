package com.pesquera.compradores.repository;

import com.pesquera.compradores.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {

    Optional<Comprador> findByRut(String rut);
    
    Optional<Comprador> findByEmail(String email);
    
    List<Comprador> findByActivo(Boolean activo);
    
    List<Comprador> findByTipoNegocio(String tipoNegocio);
}