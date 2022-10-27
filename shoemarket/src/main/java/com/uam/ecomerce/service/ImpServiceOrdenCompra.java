package com.uam.ecomerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.ecomerce.model.OrdenCompra;
import com.uam.ecomerce.repository.IDetalleOrdenCompraRepository;
import com.uam.ecomerce.repository.IOrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Component("serviceOrdenCompra")
public class ImpServiceOrdenCompra implements IServiceOrdenCompra {

    @Autowired
    private IOrdenCompraRepository repo;
    @Value("${ruta.archivos.imagen}")
    private String ruta;

    @Autowired
    private IDetalleOrdenCompraRepository repoDet;
    @Override
    public List<OrdenCompra> listAll() {
        return repo.findAll();
    }

    @Override
    public OrdenCompra saveOrder(OrdenCompra compra) throws IOException {
        return null;
    }

    @Override
    public OrdenCompra saveOrder(String compra, MultipartFile image) throws IOException{
        byte[] imgByte = image.getBytes();
        Path path = Paths.get(ruta + "//" + image.getOriginalFilename());
        if(!Files.exists(path)){
            Files.write(path, imgByte);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        OrdenCompra oCompra = objectMapper.readValue(compra, OrdenCompra.class);
        oCompra.setImage(image.getOriginalFilename());
        return repo.save(oCompra);
    }
}
