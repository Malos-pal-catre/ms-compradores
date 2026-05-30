package com.pesquera.compradores.repository;

import com.pesquera.compradores.model.OrdenCompra;
import com.pesquera.compradores.model.EstadoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    List<OrdenCompra> findByCompradorId(Long compradorId);
    
    List<OrdenCompra> findByEstado(EstadoOrden estado);
    
    List<OrdenCompra> findByEspecie(String especie);
    
    List<OrdenCompra> findByCompradorIdAndEstado(Long compradorId, EstadoOrden estado);
}