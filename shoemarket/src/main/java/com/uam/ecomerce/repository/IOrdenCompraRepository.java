package com.uam.ecomerce.repository;

import com.uam.ecomerce.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenCompraRepository extends JpaRepository<OrdenCompra,Long> {
}
