package com.jdc.product.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.product.api.base.BaseService;
import com.jdc.product.api.entity.Category;
import com.jdc.product.api.repo.CategoryRepo;

@Service
public class CategoryService extends BaseService<Category, Integer> {

	@Autowired
	public CategoryService(CategoryRepo repo) {
		super(repo);
	}

	public List<Category> findByType(String type) {
		
		StringBuffer sb = new StringBuffer("select c from Category c where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(!StringUtils.isEmpty(type)) {
			sb.append(" and LOWEr(c.type) like :type");
			params.put("type", type.toLowerCase().concat("%"));
		}
		
		return repo.search(sb.toString(), params);
	}
}
