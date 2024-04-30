package dev.rahul.product_service.Repositories.Projections;

public interface ProductWithTitleAndId {
    long getId();
    String getTitle();
    String getDescription();
}
