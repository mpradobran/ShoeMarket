package com.uam.ecomerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uam.ecomerce.model.Producto;
import com.uam.ecomerce.repository.IProductoRepository;
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
import java.util.UUID;

@Service
@Component("serviceProducto")
public class ImpServiceProducto implements IServiceProducto {

    @Autowired
    private IProductoRepository repo;

    @Value("${ruta.archivos.imagen}")
    private String ruta;
    @Override
    public List<Producto> getListProducto() {
        return repo.findAll();
    }

    @Override
    public Producto findById(UUID id) {
        return repo.findById(id).get();
    }

    @Override
    public Producto saveProducto(String productDto, MultipartFile image)
            throws IOException {
        byte[] imgByte = image.getBytes();
        Path path = Paths.get(ruta + "//" + image.getOriginalFilename());
        if (!Files.exists(path)) {
            Files.write(path,imgByte);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Producto product = objectMapper.readValue(productDto, Producto.class);
        product.setImagen(image.getOriginalFilename());
        return repo.save(product);
    }
    @Override
    public void deleteProduct(UUID id) {
        repo.deleteById(id);
    }


}
