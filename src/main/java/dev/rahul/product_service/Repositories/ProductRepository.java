package dev.rahul.product_service.Repositories;

import dev.rahul.product_service.Models.Product;
import dev.rahul.product_service.Repositories.Projections.ProductWithTitleAndId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Product save(Product entity);

    Product findByIdIs(Long id);

    List<Product> findAll();

    @Query("select p from Product p where p.category.title = :title and p.id = :id")
    Product getProductWithSpecificTitleAndId(@Param("title") String title, @Param("id") Long id);

    @Query(value = "select * from Product where id = :id and title = :title", nativeQuery = true)
    Product getProductWithSomeTitleAndId(@Param("title") String title, @Param("id") Long id);

    @Query("select p.id, p.title from Product p where p.title = :title and p.id = :id")
    ProductWithTitleAndId getProductWithSpecificTitleAndId2(@Param("title") String title, @Param("id") Long id);

}
