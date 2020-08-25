package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.ProductPropertyMapper;
import com.gotkx.productserver.model.ProductProperty;
import com.gotkx.productserver.rabbitmq.RabbitMQSender;
import com.gotkx.productserver.rabbitmq.RabbitQueue;
import com.gotkx.productserver.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {

	@Autowired
	private ProductPropertyMapper productPropertyMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(ProductProperty productProperty) {
		productPropertyMapper.add(productProperty);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"product_property\",\"id\": " + productProperty.getId() + "}"
		);
	}

	public void update(ProductProperty productProperty) {
		productPropertyMapper.update(productProperty);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"product_property\",\"id\": " + productProperty.getId() + "}"
		);
	}

	public void delete(Long id) {
		productPropertyMapper.delete(id);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"product_property\",\"id\": " + id + "}"
		);
	}

	public ProductProperty findById(Long id) {
		return productPropertyMapper.findById(id);
	}

}
