package com.pesquera.compradores.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "compradores")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String rut;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String tipoNegocio; // restaurante, pescaderia, procesadora

    @Column(nullable = false)
    private Boolean activo = true;
}