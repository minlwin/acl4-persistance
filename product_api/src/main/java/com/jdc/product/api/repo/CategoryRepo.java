package com.jdc.product.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.product.api.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	List<Category> findByType(String type);
		
}
