package com.pesquera.compradores.repository;

import com.pesquera.compradores.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {

    Optional<Comprador> findByRut(String rut);
    Optional<Comprador> findByEmail(String email);
    List<Comprador> findByActivo(Boolean activo);
    List<Comprador> findByTipoNegocio(String tipoNegocio);

    @Query("SELECT c FROM Comprador c WHERE c.activo = true AND c.tipoNegocio = :tipo")
    List<Comprador> findActivosByTipoNegocio(@Param("tipo") String tipo);

    @Query("SELECT c FROM Comprador c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Comprador> findByNombreContaining(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM compradores WHERE activo = true ORDER BY nombre ASC", nativeQuery = true)
    List<Comprador> findAllActivosOrdenados();
}