package dev.rahul.product_service.Services;

import dev.rahul.product_service.DTOS.FakeStoreProductDTO;
import dev.rahul.product_service.Models.Category;
import dev.rahul.product_service.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleproduct(Long id) {

//        FakeStoreProductDTO fakeStoreProductDto = restTemplate
//               .getForObject(
//                        "https://fakestoreapi.com/products/" + id,
//                        FakeStoreProductDTO.class);

        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        FakeStoreProductDTO fakeStoreProductDTO = responseEntity.getBody();

        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageURL(fakeStoreProductDTO.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDTO.getTitle());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setTitle(title);

        FakeStoreProductDTO response = restTemplate
                .postForObject("https://fakestoreapi.com/products",
                        fakeStoreProductDTO,
                        FakeStoreProductDTO.class);
        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDTO[] response =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO: response){
            products.add(fakeStoreProductDTO.toProduct());
        }
        return products;
    }
}
