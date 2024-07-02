package pe.edu.cibertec.api_rest_ventas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_rest_ventas.model.bd.Order;

@Service
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
