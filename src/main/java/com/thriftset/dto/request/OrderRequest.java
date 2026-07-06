package com.thriftset.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order creation request payload")
public class OrderRequest {

    @Schema(description = "Shipping address information", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Shipping address is required")
    private ShippingAddressRequest shippingAddress;

    @Schema(description = "Billing address information", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Billing address is required")
    private BillingAddressRequest billingAddress;

    @Schema(description = "Additional order notes", example = "Leave at front door")
    private String notes;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Shipping address details")
    public static class ShippingAddressRequest {

        @Schema(description = "First name", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "First name is required")
        private String firstName;

        @Schema(description = "Last name", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Last name is required")
        private String lastName;

        @Schema(description = "Street address", example = "123 Main Street", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Address is required")
        private String address;

        @Schema(description = "City", example = "Johannesburg", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "City is required")
        private String city;

        @Schema(description = "State/Province", example = "Western Cape", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "State is required")
        private String state;

        @Schema(description = "ZIP/Postal code", example = "10001", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Zip code is required")
        private String zipCode;

        @Schema(description = "Country", example = "South Africa", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Country is required")
        private String country;

        @Schema(description = "Phone number", example = "1234567890", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Phone number is required")
        private String phone;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Billing address details")
    public static class BillingAddressRequest {

        @Schema(description = "First name", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "First name is required")
        private String firstName;

        @Schema(description = "Last name", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Last name is required")
        private String lastName;

        @Schema(description = "Street address", example = "123 Main Street", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Address is required")
        private String address;

        @Schema(description = "City", example = "Johannesburg", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "City is required")
        private String city;

        @Schema(description = "State/Province", example = "Western Cape", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "State is required")
        private String state;

        @Schema(description = "ZIP/Postal code", example = "10001", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Zip code is required")
        private String zipCode;

        @Schema(description = "Country", example = "South Africa", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Country is required")
        private String country;
    }
}