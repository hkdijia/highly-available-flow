package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.ProductPropertyMapper;
import com.gotkx.productserver.model.ProductProperty;
import com.gotkx.productserver.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

	@Autowired
	private ProductPropertyMapper productPropertyMapper;
	
	public void add(ProductProperty productProperty) {
		productPropertyMapper.add(productProperty); 
	}

	public void update(ProductProperty productProperty) {
		productPropertyMapper.update(productProperty); 
	}

	public void delete(Long id) {
		productPropertyMapper.delete(id); 
	}

	public ProductProperty findById(Long id) {
		return productPropertyMapper.findById(id);
	}

}
