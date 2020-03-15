package com.jdc.product.api.repo;

import java.util.List;

import com.jdc.product.api.base.BaseRepository;
import com.jdc.product.api.entity.Category;

public interface CategoryRepo extends BaseRepository<Category, Integer>{

	List<Category> findByType(String type);
		
}
