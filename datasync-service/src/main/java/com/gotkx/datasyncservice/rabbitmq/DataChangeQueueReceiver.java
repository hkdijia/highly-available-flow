package com.gotkx.datasyncservice.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "data-change-queue")
public class DataChangeQueueReceiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("从data-change-queue队列接收到一条消息：" + message);
    }

}
