package com.uam.ecomerce.service;

import com.uam.ecomerce.model.DetalleOrdenCompra;
import com.uam.ecomerce.model.OrdenCompra;
import com.uam.ecomerce.repository.IDetalleOrdenCompraRepository;
import com.uam.ecomerce.repository.IOrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("Service Orden Compra")
public class ImpServiceOrdenCompra implements IServiceOrdenCompra {

    @Autowired
    private IOrdenCompraRepository repo;

    @Autowired
    private IDetalleOrdenCompraRepository repoDet;
    @Override
    public List<OrdenCompra> listAll() {
        return repo.findAll();
    }
    @Override
    public OrdenCompra saveOrder(OrdenCompra oc) {
        OrdenCompra o = new OrdenCompra();
        o.setTotal(oc.getTotal());
        o.setFechaCompra(oc.getFechaCompra());

        List<DetalleOrdenCompra> Detalle = oc.getDetalleOrdenes();

        for (DetalleOrdenCompra det : Detalle) {
            det.setOrdenCompra(o);
        }
        o.setDetalleOrdenes(Detalle);

       /*save master
       //order.setDetalles(null);
       //Order o = repo.save(order);
       for (DetalleOrder det : detalles) {
           det.setOrder(o);
       }
       repoDet.saveAll(detalles);
       o.setDetalles(detalles);
       return o;*/
        return repo.save(o);
    }
}  <<
