package com.uam.ecomerce.controller;

import com.uam.ecomerce.model.Usuario;
import com.uam.ecomerce.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    @Qualifier("serviceUsuario")
    private IServiceUsuario serviceUsuario;

    //1- Listar todos
    @GetMapping("list")
    private List<Usuario> listAll(){
        return serviceUsuario.listAll();
    }

    //2 - Buscar por ID
    @GetMapping({"/{id}"})
    public Usuario getUsuario(@PathVariable UUID id) {
        return serviceUsuario.findById(id);
    }

    //3 - Crear y actualizar
    @PostMapping("/save")
    private Usuario save(@RequestBody Usuario user) {
        return serviceUsuario.save(user);
    }

    //4 - Borrar por ID
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable UUID id) {
        serviceUsuario.deleteUsuario(id);
    }

}
