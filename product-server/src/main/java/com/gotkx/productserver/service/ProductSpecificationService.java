package com.gotkx.productserver.service;


import com.gotkx.productserver.model.ProductSpecification;

public interface ProductSpecificationService {
	
	public void add(ProductSpecification productSpecification);
	
	public void update(ProductSpecification productSpecification);
	
	public void delete(Long id);
	
	public ProductSpecification findById(Long id);
	
}
