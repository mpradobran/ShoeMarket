package com.uam.ecomerce.service;

import com.uam.ecomerce.model.Producto;
import com.uam.ecomerce.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public interface IServiceUsuario {

    public List<Usuario> listAll();
    public Usuario findById(UUID id);
    public void deleteUsuario(UUID id);
    Usuario save(Usuario user);
}
