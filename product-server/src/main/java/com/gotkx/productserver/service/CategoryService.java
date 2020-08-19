package com.gotkx.productserver.service;


import com.gotkx.productserver.model.Category;

public interface CategoryService {
	
	public void add(Category category);
	
	public void update(Category category);
	
	public void delete(Long id);
	
	public Category findById(Long id);
	
}
