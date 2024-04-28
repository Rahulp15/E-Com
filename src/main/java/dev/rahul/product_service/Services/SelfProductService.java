package dev.rahul.product_service.Services;

import dev.rahul.product_service.Models.Product;
import dev.rahul.product_service.Repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
@Primary
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getSingleproduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageURL(image);
        product.setCategory(category);



        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
