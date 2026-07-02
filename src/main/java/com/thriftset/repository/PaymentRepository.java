package com.thriftset.repository;

import com.thriftset.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
    Optional<Payment> findByOrderId(Long orderId);
    
    Optional<Payment> findByStripePaymentIntentId(String stripePaymentIntentId);
    
    boolean existsByOrderId(Long orderId);
}