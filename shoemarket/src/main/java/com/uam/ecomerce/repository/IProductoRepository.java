package com.uam.ecomerce.repository;

import com.uam.ecomerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProductoRepository extends JpaRepository<Producto, UUID> {
}
