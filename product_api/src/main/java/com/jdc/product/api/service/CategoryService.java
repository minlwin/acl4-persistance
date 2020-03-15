package com.jdc.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.product.api.entity.Category;
import com.jdc.product.api.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;

	public List<Category> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Category save(Category c) {
		return repo.save(c);
	}

	public List<Category> findByType(String type) {
		return repo.findByType(type);
	}
}
