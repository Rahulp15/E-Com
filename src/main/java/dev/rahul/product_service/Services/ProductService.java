package dev.rahul.product_service.Services;

import dev.rahul.product_service.DTOS.CreateProductRequestDTO;
import dev.rahul.product_service.Models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleproduct(Long id);
    public Product createProduct(String title, String description, String image,
                                 String category, double price);
    public List<Product> getAllProducts();
}
