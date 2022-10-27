package com.uam.ecomerce.service;

import com.uam.ecomerce.model.OrdenCompra;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface IServiceOrdenCompra {

    public List<OrdenCompra> listAll();

    OrdenCompra saveOrder(OrdenCompra compra) throws IOException;

    OrdenCompra saveOrder(String compra, MultipartFile image) throws IOException;
}
