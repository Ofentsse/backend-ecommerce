package com.thriftset.dto.response;

import com.thriftset.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal originalPrice;
    private String category;
    private List<String> images;
    private Integer stock;
    private Double rating;
    private Integer reviewCount;
    private List<String> sizes;
    private List<String> colors;
    private boolean featured;
    private boolean newArrival;
    private boolean onSale;

    public static ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .originalPrice(product.getOriginalPrice())
                .category(product.getCategory())
                .images(product.getImages())
                .stock(product.getStock())
                .rating(product.getRating())
                .reviewCount(product.getReviewCount())
                .sizes(product.getSizes())
                .colors(product.getColors())
                .featured(product.isFeatured())
                .newArrival(product.isNewArrival())
                .onSale(product.isOnSale())
                .build();
    }
}