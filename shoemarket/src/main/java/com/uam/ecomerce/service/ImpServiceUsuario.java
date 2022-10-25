package com.uam.ecomerce.service;

import com.uam.ecomerce.model.Producto;
import com.uam.ecomerce.model.Usuario;
import com.uam.ecomerce.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Component("serviceUsuario")
public class ImpServiceUsuario implements IServiceUsuario {

    @Autowired
    private IUsuarioRepository userRepo;
    @Override
    public List<Usuario> listAll() {
        return userRepo.findAll();
    }

    @Override
    public Usuario findById(UUID id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteUsuario(UUID id) {
        userRepo.deleteById(id);
    }

    @Override
    public Usuario save(Usuario user) {
        return userRepo.save(user);
    }
}
