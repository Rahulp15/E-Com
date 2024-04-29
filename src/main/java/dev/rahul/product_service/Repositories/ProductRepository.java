package dev.rahul.product_service.Repositories;

import dev.rahul.product_service.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Product save(Product entity);

    Product findByIdIs(Long id);

    List<Product> findAll();

}
