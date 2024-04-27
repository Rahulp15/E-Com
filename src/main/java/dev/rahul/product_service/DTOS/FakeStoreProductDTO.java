package dev.rahul.product_service.DTOS;

import dev.rahul.product_service.Models.Category;
import dev.rahul.product_service.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setImageURL(getImage());

        Category category = new Category();
        category.setTitle(getTitle());
        product.setCategory(category);

        return product;
    }
}
