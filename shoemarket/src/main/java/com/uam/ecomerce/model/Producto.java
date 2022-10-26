package com.uam.ecomerce.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "Producto")
public class Producto {

    @Id
    @SequenceGenerator(name = "producto_seq",
            sequenceName = "producto_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "producto_seq")

    private UUID ID;
    private String Nombre;
    private Float Precio;
    private String Descripcion;

    @OneToMany(mappedBy = "producto")
    private List<Imagenes> imagenes;
}
