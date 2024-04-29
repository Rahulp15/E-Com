package dev.rahul.product_service.Controllers;

import dev.rahul.product_service.DTOS.CreateProductRequestDTO;
import dev.rahul.product_service.Models.Product;
import dev.rahul.product_service.Services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        return productService.createProduct(
                createProductRequestDTO.getTitle(),
                createProductRequestDTO.getDescription(),
                createProductRequestDTO.getImage(),
                createProductRequestDTO.getCategory(),
                createProductRequestDTO.getPrice()
        );
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> responseData = productService.getAllProducts();

        ResponseEntity<List<Product>> responseEntity =
                new ResponseEntity<>(responseData, HttpStatusCode.valueOf(202));

        return responseEntity;
    }


    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleproduct(id);
    }

    public void deleteProduct(Long id){

    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDTO> HandleNullPointerException(){
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setMessage("Something went wrong. Please try again");
//
//        return new ResponseEntity<>(errorDTO,
//            HttpStatusCode.valueOf(404));
//    }

}