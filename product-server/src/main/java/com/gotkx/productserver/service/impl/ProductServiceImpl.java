package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.ProductMapper;
import com.gotkx.productserver.model.Product;
import com.gotkx.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public void add(Product product) {
		productMapper.add(product); 
	}

	public void update(Product product) {
		productMapper.update(product); 
	}

	public void delete(Long id) {
		productMapper.delete(id); 
	}

	public Product findById(Long id) {
		return productMapper.findById(id);
	}

}
