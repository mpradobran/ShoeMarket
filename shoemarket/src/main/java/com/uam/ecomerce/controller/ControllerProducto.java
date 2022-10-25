package com.uam.ecomerce.controller;

import com.uam.ecomerce.model.Producto;
import com.uam.ecomerce.service.IServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ControllerProducto {

    @Qualifier("serviceProducto")
    @Autowired
    private IServiceProducto service;

    //1- Listar todos
    @GetMapping("/list")
    public List<Producto> getAll() {
        return service.getListProducto();
    }
    //2 - Buscar por ID
    @GetMapping({"/{id}"})
    public Producto getProduct(@PathVariable UUID id) {
        return service.findById(id);
    }

    //3 - Crear y actualizar
    @PostMapping("/save")
    public Producto saveProduct(@RequestPart("product")  String productDto, @RequestPart("image") MultipartFile image) throws IOException {
        return service.saveProducto(productDto,image);
    }
    //4 - Borrar por ID
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        service.deleteProduct(id);
    }
}
