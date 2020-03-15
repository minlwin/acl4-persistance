package com.jdc.product.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.product.api.entity.Category;
import com.jdc.product.api.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryApi {

	@Autowired
	private CategoryService service;
	
	@GetMapping("types")
	public List<String> hello() {
		return Arrays.asList("Grand Menu", "Set Menu","Drinks");
	}
	
	@GetMapping("types/{t}")
	public List<Category> findByType(@PathVariable("t") String type) {
		return service.findByType(type);
	}
	
	@GetMapping
	public List<Category> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Category create(@RequestBody Category c) {
		return service.save(c);
	}
}
