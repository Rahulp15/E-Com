package dev.rahul.product_service.Services;

import dev.rahul.product_service.Models.Category;
import dev.rahul.product_service.Models.Product;
import dev.rahul.product_service.Repositories.CategoryRepository;
import dev.rahul.product_service.Repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleproduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, String categoryTitle, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(image);

        Category categoryFromDatabase = categoryRepository.findbyTitle(categoryTitle);
        if(categoryFromDatabase == null){
            Category newCateory = new Category();
            newCateory.setTitle(categoryTitle);
            categoryFromDatabase = categoryRepository.save(newCateory);
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
