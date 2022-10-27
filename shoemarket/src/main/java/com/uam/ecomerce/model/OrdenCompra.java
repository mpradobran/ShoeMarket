package com.uam.ecomerce.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="OrdenCompra")
public class OrdenCompra {

    @Id
    @SequenceGenerator(name = "OrdenCompra_seq",
            sequenceName = "OrdenCompra_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "OrdenCompra_seq")

    private UUID ID;
    private Double Total;
    private Date FechaCompra;
    private String image;
    @OneToMany(mappedBy = "ordenCompra")
    private List<DetalleOrdenCompra> DetalleOrdenes;


    private Long usuario;
}
