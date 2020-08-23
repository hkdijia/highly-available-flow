package com.gotkx.inventoryserver.service.impl;

import com.gotkx.inventoryserver.mapper.ProductInventoryMapper;
import com.gotkx.inventoryserver.model.ProductInventory;
import com.gotkx.inventoryserver.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

	@Autowired
	private ProductInventoryMapper productInventoryMapper;
	
	public void add(ProductInventory productInventory) {
		productInventoryMapper.add(productInventory); 
	}

	public void update(ProductInventory productInventory) {
		productInventoryMapper.update(productInventory); 
	}

	public void delete(Long id) {
		productInventoryMapper.delete(id); 
	}

	public ProductInventory findById(Long id) {
		return productInventoryMapper.findById(id);
	}

}
