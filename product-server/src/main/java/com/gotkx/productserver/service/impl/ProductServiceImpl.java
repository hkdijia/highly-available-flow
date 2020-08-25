package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.ProductMapper;
import com.gotkx.productserver.model.Product;
import com.gotkx.productserver.rabbitmq.RabbitMQSender;
import com.gotkx.productserver.rabbitmq.RabbitQueue;
import com.gotkx.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(Product product) {
		productMapper.add(product);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"product\",\"id\": " + product.getId() + "}"
		);
	}

	public void update(Product product) {
		productMapper.update(product);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"product\",\"id\": " + product.getId() + "}"
		);
	}

	public void delete(Long id) {
		productMapper.delete(id);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"product\",\"id\": " + id + "}"
		);
	}

	public Product findById(Long id) {
		return productMapper.findById(id);
	}

}
