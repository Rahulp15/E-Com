package dev.rahul.product_service.Repositories;

import dev.rahul.product_service.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);

    Category save(Category category);

//    Optional<Category> findAllBy(Long id);
}
