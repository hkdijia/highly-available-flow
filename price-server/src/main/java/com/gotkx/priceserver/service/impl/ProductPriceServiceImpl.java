package com.gotkx.priceserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gotkx.priceserver.mapper.ProductPriceMapper;
import com.gotkx.priceserver.model.ProductPrice;
import com.gotkx.priceserver.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Service
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceMapper productPriceMapper;

	@Autowired
	private JedisPool jedisPool;
	
	public void add(ProductPrice productPrice) {
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
	}

	public void update(ProductPrice productPrice) {
		productPriceMapper.update(productPrice);
		Jedis jedis = jedisPool.getResource();
		jedis.set("product_price_" + productPrice.getProductId(), JSONObject.toJSONString(productPrice));
	}

	public void delete(Long id) {
		ProductPrice productPrice = findById(id);
		productPriceMapper.delete(id);
		Jedis jedis = jedisPool.getResource();
		jedis.del("product_price_" + productPrice.getProductId());
	}

	public ProductPrice findById(Long id) {
		return productPriceMapper.findById(id);
	}

}
