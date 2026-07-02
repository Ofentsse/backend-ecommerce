package com.thriftset.controller;

import com.thriftset.dto.request.PaymentRequest;
import com.thriftset.dto.response.PaymentResponse;
import com.thriftset.service.PaymentService;
import com.thriftset.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-intent")
    public ResponseEntity<ApiResponse<PaymentResponse>> createPaymentIntent(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.createPaymentIntent(userDetails.getUsername(), request);
        return ResponseEntity.ok(ApiResponse.success("Payment intent created", response));
    }

    @PostMapping("/confirm/{orderId}")
    public ResponseEntity<ApiResponse<PaymentResponse>> confirmPayment(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long orderId,
            @RequestParam String paymentIntentId) {
        PaymentResponse response = paymentService.confirmPayment(userDetails.getUsername(), orderId, paymentIntentId);
        return ResponseEntity.ok(ApiResponse.success("Payment confirmed", response));
    }

    @GetMapping("/status/{orderId}")
    public ResponseEntity<ApiResponse<PaymentResponse>> getPaymentStatus(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long orderId) {
        PaymentResponse response = paymentService.getPaymentStatus(userDetails.getUsername(), orderId);
        return ResponseEntity.ok(ApiResponse.success("Payment status retrieved", response));
    }
}