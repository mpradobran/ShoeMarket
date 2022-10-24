package com.uam.ecomerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue
    private UUID ID;
    private String Nombre;
    private String Username;
    private String Clave;
    private Boolean Estado;
    private String Correo;
    private String Celular;

    @OneToOne
    @JoinColumn(name="ID_OrdenCompra")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OrdenCompra OrdenCompra;
}
