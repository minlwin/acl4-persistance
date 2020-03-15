package com.jdc.product.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.product.api.base.BaseService;
import com.jdc.product.api.entity.Product;
import com.jdc.product.api.repo.ProductRepo;

@Service
public class ProductService extends BaseService<Product, Integer> {

	private ProductRepo myRepo;

	@Autowired
	public ProductService(ProductRepo myRepo) {
		super(myRepo);
		this.myRepo = myRepo;
	}
	
	
}
