package com.thriftset.repository;

import com.thriftset.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by category
    Page<Product> findByCategory(String category, Pageable pageable);
    
    // Find products by name (search)
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    // Find products by price range
    Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
    
    // Find featured products
    Page<Product> findByFeaturedTrue(Pageable pageable);
    
    // Find new arrivals
    Page<Product> findByNewArrivalTrue(Pageable pageable);
    
    // Find products on sale
    Page<Product> findByOnSaleTrue(Pageable pageable);
    
    // Get all distinct categories
    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> findDistinctCategories();
    
    // Get latest products
    List<Product> findTop10ByOrderByCreatedAtDesc();
}