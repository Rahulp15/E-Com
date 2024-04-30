package dev.rahul.product_service;

import dev.rahul.product_service.Models.Category;
import dev.rahul.product_service.Models.Product;
import dev.rahul.product_service.Repositories.CategoryRepository;
import dev.rahul.product_service.Repositories.ProductRepository;
import dev.rahul.product_service.Repositories.Projections.ProductWithTitleAndId;
import dev.rahul.product_service.Services.ProductService;
import jakarta.transaction.Transactional;
import  org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testingQuery(){
        Product product = productRepository
                .getProductWithSpecificTitleAndId("phone12", 52L);

        System.out.println(product.getTitle());
    }

    @Test
    public void testingQuery2(){
        ProductWithTitleAndId product = productRepository
                .getProductWithSpecificTitleAndId2("phone12", 52L);

        System.out.println(product.getTitle());
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());
    }

    @Test
    @Transactional
    public void testingFetchTypes() {
        Category category = categoryRepository.findByTitle("phone12");
        System.out.println(category.getProducts());
    }

    @Test
    public void testingFetchTypes2() {
        Category category = categoryRepository.findByTitle("phone12");
        System.out.println(category.getTitle());
    }

//    @Test
//    public void testingFetchTypes3() {
//        Optional<Category> category = categoryRepository.findById(52L);
//        System.out.println(category.get().getTitle());
//    }
}
