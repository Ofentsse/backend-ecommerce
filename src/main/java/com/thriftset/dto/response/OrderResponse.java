package com.thriftset.dto.response;

import com.thriftset.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private String orderNumber;
    private List<OrderItemResponse> items;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal shippingCost;
    private BigDecimal totalAmount;
    private String status;
    private String paymentStatus;
    private ShippingAddressDTO shippingAddress;
    private BillingAddressDTO billingAddress;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShippingAddressDTO {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String country;
        private String phone;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BillingAddressDTO {
        private String firstName;
        private String lastName;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }

    public static OrderResponse fromOrder(Order order) {
        OrderResponse response = OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .subtotal(order.getSubtotal())
                .discount(order.getDiscount())
                .tax(order.getTax())
                .shippingCost(order.getShippingCost())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().name())
                .paymentStatus(order.getPaymentStatus().name())
                .notes(order.getNotes())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();

        // Set items
        if (order.getItems() != null) {
            response.setItems(order.getItems().stream()
                    .map(OrderItemResponse::fromOrderItem)
                    .collect(Collectors.toList()));
        }

        // Set shipping address
        if (order.getShippingAddress() != null) {
            response.setShippingAddress(ShippingAddressDTO.builder()
                    .firstName(order.getShippingAddress().getFirstName())
                    .lastName(order.getShippingAddress().getLastName())
                    .address(order.getShippingAddress().getAddress())
                    .city(order.getShippingAddress().getCity())
                    .state(order.getShippingAddress().getState())
                    .zipCode(order.getShippingAddress().getZipCode())
                    .country(order.getShippingAddress().getCountry())
                    .phone(order.getShippingAddress().getPhone())
                    .build());
        }

        // Set billing address
        if (order.getBillingAddress() != null) {
            response.setBillingAddress(BillingAddressDTO.builder()
                    .firstName(order.getBillingAddress().getFirstName())
                    .lastName(order.getBillingAddress().getLastName())
                    .address(order.getBillingAddress().getAddress())
                    .city(order.getBillingAddress().getCity())
                    .state(order.getBillingAddress().getState())
                    .zipCode(order.getBillingAddress().getZipCode())
                    .country(order.getBillingAddress().getCountry())
                    .build());
        }

        return response;
    }
}