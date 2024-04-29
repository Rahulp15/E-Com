package dev.rahul.product_service.Controllers;

import dev.rahul.product_service.Models.Category;
import dev.rahul.product_service.Models.Product;
import dev.rahul.product_service.Repositories.CategoryRepository;
import dev.rahul.product_service.Repositories.ProductRepository;
import dev.rahul.product_service.Services.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService (ProductRepository productRepository,
                               CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleproduct(Long id) {
        return productRepository.findByIdIs(id);
    }

    @Override
    public Product createProduct(String title, String description, String image, String categoryTitle, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(image);

        Category categoryfromDatabse = categoryRepository.findByTitle(categoryTitle);
        if(categoryfromDatabse == null){
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            categoryfromDatabse = newCategory;
            //categoryfromDatabse = categoryRepository.save(newCategory);
        }

        product.setCategory(categoryfromDatabse);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
