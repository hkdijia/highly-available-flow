package com.gotkx.productserver.controller;

import com.gotkx.productserver.model.ProductProperty;
import com.gotkx.productserver.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

	@Autowired
	private ProductPropertyService productPropertyService;
	
	@RequestMapping("/add") 
	@ResponseBody
	public String add(ProductProperty productProperty) {
		try {
			productPropertyService.add(productProperty);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/update") 
	@ResponseBody
	public String update(ProductProperty productProperty) {
		try {
			productPropertyService.update(productProperty); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/delete") 
	@ResponseBody
	public String delete(Long id) {
		try {
			productPropertyService.delete(id); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public ProductProperty findById(Long id){
		try {
			ProductProperty property = productPropertyService.findById(id);
			return property;
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductProperty();
	}
	
}
