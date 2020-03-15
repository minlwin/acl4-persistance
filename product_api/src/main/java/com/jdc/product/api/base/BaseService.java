package com.jdc.product.api.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class BaseService<T, ID extends Number> {
	
	private JpaRepository<T, ID> repo;
	
	public BaseService(JpaRepository<T, ID> repo) {
		this.repo = repo;
	}
	
	@Transactional
	public T save(T data)  {
		return repo.save(data);
	}
	
	public List<T> findAll() {
		return repo.findAll();
	}
	
	public Optional<T> findById(ID id) {
		return repo.findById(id);
	}
	
	public void deleteById(ID id) {
		repo.deleteById(id);
	}
}
