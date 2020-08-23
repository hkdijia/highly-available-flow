package com.gotkx.priceserver.service.impl;

import com.gotkx.priceserver.mapper.ProductPriceMapper;
import com.gotkx.priceserver.model.ProductPrice;
import com.gotkx.priceserver.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceMapper productPriceMapper;
	
	public void add(ProductPrice productPrice) {
		productPriceMapper.add(productPrice); 
	}

	public void update(ProductPrice productPrice) {
		productPriceMapper.update(productPrice); 
	}

	public void delete(Long id) {
		productPriceMapper.delete(id); 
	}

	public ProductPrice findById(Long id) {
		return productPriceMapper.findById(id);
	}

}
