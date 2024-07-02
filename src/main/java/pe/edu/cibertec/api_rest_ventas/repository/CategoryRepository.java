package pe.edu.cibertec.api_rest_ventas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.api_rest_ventas.model.bd.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


}
