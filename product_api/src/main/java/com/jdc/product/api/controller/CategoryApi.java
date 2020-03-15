package com.jdc.product.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.product.api.base.BaseController;
import com.jdc.product.api.entity.Category;
import com.jdc.product.api.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryApi extends BaseController<Category, Integer>{

	private CategoryService myService;
	
	@Autowired
	public CategoryApi(CategoryService myService) {
		super(myService);
		this.myService = myService;
	}

	@GetMapping("types")
	public List<String> hello() {
		return Arrays.asList("Grand Menu", "Set Menu","Drinks");
	}
	
	@GetMapping("types/{type}")
	public List<Category> findByType(@PathVariable String type) {
		return myService.findByType(type);
	}
	
}
