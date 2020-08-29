package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.BrandMapper;
import com.gotkx.productserver.model.Brand;
import com.gotkx.productserver.rabbitmq.RabbitMQSender;
import com.gotkx.productserver.rabbitmq.RabbitQueue;
import com.gotkx.productserver.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(Brand brand) {
		brandMapper.add(brand);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"brand\",\"id\": " + brand.getId() + "}"
		);
	}

	public void update(Brand brand) {
		brandMapper.update(brand);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"brand\",\"id\": " + brand.getId() + "}"
		);
	}

	public void delete(Long id) {
		brandMapper.delete(id);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"brand\",\"id\": " + id + "}"
		);
	}

	public Brand findById(Long id) {
		return brandMapper.findById(id);
	}

}
