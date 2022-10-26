package com.uam.ecomerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "imagenes")
public class Imagenes {
    @Id
    @SequenceGenerator(name = "imagen_seq", sequenceName = "imagen_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagen_seq")
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

}
