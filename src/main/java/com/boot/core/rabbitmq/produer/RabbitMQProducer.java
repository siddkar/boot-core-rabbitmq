package com.boot.core.rabbitmq.produer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.boot.core.rabbitmq.model.DeviceInfo;

@Component
public class RabbitMQProducer {
	
	@Value("${rabbitmq.custom.queue}")
	private String QUEUE;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
    
	public void publish(DeviceInfo deviceInfo) {
		this.rabbitTemplate.convertAndSend(QUEUE, deviceInfo);
	}
	
}
