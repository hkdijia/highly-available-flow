package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.CategoryMapper;
import com.gotkx.productserver.model.Category;
import com.gotkx.productserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public void add(Category category) {
		categoryMapper.add(category); 
	}

	public void update(Category category) {
		categoryMapper.update(category); 
	}

	public void delete(Long id) {
		categoryMapper.delete(id); 
	}

	public Category findById(Long id) {
		return categoryMapper.findById(id);
	}

}
