package com.uam.ecomerce.service;

import com.uam.ecomerce.model.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceOrdenCompra {

    public List<OrdenCompra> listAll();

    public OrdenCompra saveOrder(OrdenCompra orden);
}
