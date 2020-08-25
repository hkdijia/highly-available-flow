package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.ProductSpecificationMapper;
import com.gotkx.productserver.model.ProductSpecification;
import com.gotkx.productserver.rabbitmq.RabbitMQSender;
import com.gotkx.productserver.rabbitmq.RabbitQueue;
import com.gotkx.productserver.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

	@Autowired
	private ProductSpecificationMapper productSpecificationMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(ProductSpecification productSpecification) {
		productSpecificationMapper.add(productSpecification);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"product_specification\",\"id\": " + productSpecification.getId() + "}"
		);
	}

	public void update(ProductSpecification productSpecification) {
		productSpecificationMapper.update(productSpecification);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"product_specification\",\"id\": " + productSpecification.getId() + "}"
		);
	}

	public void delete(Long id) {
		productSpecificationMapper.delete(id);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"product_specification\",\"id\": " + id + "}"
		);
	}

	public ProductSpecification findById(Long id) {
		return productSpecificationMapper.findById(id);
	}

}
