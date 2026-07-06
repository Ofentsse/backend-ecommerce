package com.thriftset.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Product creation/update request payload")
public class ProductRequest {

    @Schema(description = "Product name", example = "Denim Jacket", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Product name is required")
    private String name;

    @Schema(description = "Product description", example = "A classic denim jacket with distressed details.")
    private String description;

    @Schema(description = "Product price", example = "89.99", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be greater than 0")
    private BigDecimal price;

    @Schema(description = "Original price (before discount)", example = "129.99")
    private BigDecimal originalPrice;

    @Schema(description = "Product category", example = "Jackets", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Category is required")
    private String category;

    @Schema(description = "List of product image URLs", example = "[\"https://example.com/image1.jpg\"]")
    private List<String> images;

    @Schema(description = "Product stock quantity", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock must be greater than or equal to 0")
    private Integer stock;

    @Schema(description = "Product rating", example = "4.5")
    private Double rating;

    @Schema(description = "Number of reviews", example = "120")
    private Integer reviewCount;

    @Schema(description = "Available sizes", example = "[\"S\", \"M\", \"L\", \"XL\"]")
    private List<String> sizes;

    @Schema(description = "Available colors", example = "[\"Blue\", \"Black\"]")
    private List<String> colors;

    @Schema(description = "Is product featured?", example = "true")
    private boolean featured;

    @Schema(description = "Is product new arrival?", example = "true")
    private boolean newArrival;

    @Schema(description = "Is product on sale?", example = "true")
    private boolean onSale;
}