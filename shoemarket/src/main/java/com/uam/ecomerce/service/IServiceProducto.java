package com.uam.ecomerce.service;

import com.uam.ecomerce.model.Producto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public interface IServiceProducto {

    public List<Producto> getListProducto();

    public Producto findById(UUID id);

     Producto saveProducto(String productDto, MultipartFile image)
            throws IOException;

    public void deleteProduct(UUID id);
}
