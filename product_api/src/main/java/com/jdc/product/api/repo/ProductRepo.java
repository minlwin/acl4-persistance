package com.jdc.product.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.product.api.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
