package com.gotkx.productserver.service;


import com.gotkx.productserver.model.Brand;

public interface BrandService {
	
	public void add(Brand brand);
	
	public void update(Brand brand);
	
	public void delete(Long id);
	
	public Brand findById(Long id);
	
}
