package com.uam.ecomerce.repository;

import com.uam.ecomerce.model.DetalleOrdenCompra;
import com.uam.ecomerce.model.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenesRepository extends JpaRepository<Imagenes,Long> {
}
