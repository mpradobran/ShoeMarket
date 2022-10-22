package com.uam.ecomerce.repository;

import com.uam.ecomerce.model.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra,Long> {
}
