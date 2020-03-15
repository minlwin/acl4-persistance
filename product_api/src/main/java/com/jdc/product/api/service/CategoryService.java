package com.jdc.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.product.api.base.BaseService;
import com.jdc.product.api.entity.Category;
import com.jdc.product.api.repo.CategoryRepo;

@Service
public class CategoryService extends BaseService<Category, Integer> {

	@Autowired
	public CategoryService(CategoryRepo repo) {
		super(repo);
		myRepo = repo;
	}

	private CategoryRepo myRepo;

	public List<Category> findByType(String type) {
		return myRepo.findByType(type);
	}
}
