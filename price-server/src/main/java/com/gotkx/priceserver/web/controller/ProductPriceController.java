package com.gotkx.priceserver.web.controller;

import com.gotkx.priceserver.model.ProductPrice;
import com.gotkx.priceserver.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product-price")
public class ProductPriceController {

	@Autowired
	private ProductPriceService productPriceService;
	
	@RequestMapping("/add") 
	@ResponseBody
	public String add(ProductPrice productPrice) {
		try {
			productPriceService.add(productPrice);
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/update") 
	@ResponseBody
	public String update(ProductPrice productPrice) {
		try {
			productPriceService.update(productPrice); 
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
			productPriceService.delete(id); 
		} catch (Exception e) {
			e.printStackTrace(); 
			return "error";
		}
		return "success";
	}
	
	@RequestMapping("/findById") 
	@ResponseBody
	public ProductPrice findById(Long id){
		try {
			return productPriceService.findById(id);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return new ProductPrice();
	}
	
}