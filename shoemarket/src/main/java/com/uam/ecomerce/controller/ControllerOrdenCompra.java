package com.uam.ecomerce.controller;
import com.uam.ecomerce.model.OrdenCompra;
import com.uam.ecomerce.service.IServiceOrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class ControllerOrdenCompra {

    @Autowired
    @Qualifier("serviceOrdenCompra")
    private IServiceOrdenCompra service;

    //1.Listar Todos
    @GetMapping("/list")
    public List<OrdenCompra> getAll(){
        return service.listAll();
    }

    @PostMapping("/save")
    public OrdenCompra saveOrder(@RequestBody OrdenCompra order){
        return service.saveOrder(order);
    }
}
