package com.gotkx.productserver.service.impl;

import com.gotkx.productserver.mapper.CategoryMapper;
import com.gotkx.productserver.model.Category;
import com.gotkx.productserver.rabbitmq.RabbitMQSender;
import com.gotkx.productserver.rabbitmq.RabbitQueue;
import com.gotkx.productserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	public void add(Category category) {
		categoryMapper.add(category);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"category\",\"id\": " + category.getId() + "}"
		);
	}

	public void update(Category category) {
		categoryMapper.update(category);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"category\",\"id\": " + category.getId() + "}"
		);
	}

	public void delete(Long id) {
		categoryMapper.delete(id);
		rabbitMQSender.send(
				RabbitQueue.DATA_CHANGE_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"category\",\"id\": " + id + "}"
		);
	}

	public Category findById(Long id) {
		return categoryMapper.findById(id);
	}

}
