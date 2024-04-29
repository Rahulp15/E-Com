package dev.rahul.product_service.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;
}