package com.boot.core.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreRabbitMQConfig {
	
	@Value("${rabbitmq.custom.queue}")
	private String QUEUE;
	
	@Value("${rabbitmq.custom.exchange}")
	private String EXCHANGE;
	
	@Bean
	public Queue dellQueue() {
		return QueueBuilder.durable(QUEUE).build();
	}

	@Bean
	public Exchange dellExchange() {
		return ExchangeBuilder.topicExchange(EXCHANGE).build();
	}

	@Bean
	public Binding binding(Queue dellQueue, TopicExchange dellExchange) {
		return BindingBuilder.bind(dellQueue).to(dellExchange).with(QUEUE);
	}
	
	@Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
 
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
   
}
