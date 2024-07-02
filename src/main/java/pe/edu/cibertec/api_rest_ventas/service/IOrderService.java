package pe.edu.cibertec.api_rest_ventas.service;

import pe.edu.cibertec.api_rest_ventas.model.bd.Order;

import java.util.List;

public interface IOrderService {

    List<Order> listarOrdenes();

}
