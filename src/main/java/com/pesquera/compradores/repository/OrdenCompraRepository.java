package com.pesquera.compradores.repository;

import com.pesquera.compradores.model.OrdenCompra;
import com.pesquera.compradores.model.EstadoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {

    List<OrdenCompra> findByCompradorId(Long compradorId);
    List<OrdenCompra> findByEstado(EstadoOrden estado);
    List<OrdenCompra> findByEspecie(String especie);
    List<OrdenCompra> findByCompradorIdAndEstado(Long compradorId, EstadoOrden estado);

    @Query("SELECT o FROM OrdenCompra o WHERE o.comprador.id = :compradorId AND o.estado = 'PENDIENTE'")
    List<OrdenCompra> findOrdenesPendientesByComprador(@Param("compradorId") Long compradorId);

    @Query("SELECT o FROM OrdenCompra o WHERE o.especie = :especie AND o.estado = 'PENDIENTE' ORDER BY o.precioMaximo DESC")
    List<OrdenCompra> findOrdenesPendientesByEspecieOrdenadas(@Param("especie") String especie);

    @Query(value = "SELECT * FROM ordenes_compra WHERE estado = 'PENDIENTE' ORDER BY fecha_creacion ASC", nativeQuery = true)
    List<OrdenCompra> findTodasOrdenesPendientes();
}