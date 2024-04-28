package dev.rahul.product_service.Repositories;

import dev.rahul.product_service.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product entity);
}
