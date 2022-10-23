package com.uam.ecomerce.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class DetalleOrdenCompra {

    @Id
    @SequenceGenerator(name = "DetalleOrdenCompra_seq",
            sequenceName = "DetalleOrdenCompra_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "DetalleOrdenCompra_seq")
    private UUID ID;
    private Long ProductoID;
    private int Cantidad;
    private Double Precio;

    @ManyToOne
    @JoinColumn(name="ID_OrdenCompra")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OrdenCompra OrdenCompra;

}