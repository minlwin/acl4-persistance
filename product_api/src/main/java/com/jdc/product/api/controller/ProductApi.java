package com.jdc.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.product.api.base.BaseController;
import com.jdc.product.api.entity.Product;
import com.jdc.product.api.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductApi extends BaseController<Product, Integer>{

	@Autowired
	public ProductApi(ProductService myService) {
		super(myService);
	}
	
	
}
