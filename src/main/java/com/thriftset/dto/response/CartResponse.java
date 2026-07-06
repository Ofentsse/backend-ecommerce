package com.thriftset.dto.response;

import com.thriftset.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private Long id;
    private List<CartItemResponse> items;
    private BigDecimal totalPrice;
    private int itemCount;

    public static CartResponse fromCart(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .items(cart.getItems().stream()
                        .map(CartItemResponse::fromCartItem)
                        .collect(Collectors.toList()))
                .totalPrice(cart.getTotalPrice())
                .itemCount(cart.getItems().size())
                .build();
    }
}