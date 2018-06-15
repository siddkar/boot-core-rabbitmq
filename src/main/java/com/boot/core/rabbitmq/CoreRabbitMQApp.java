package com.boot.core.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.core.rabbitmq.model.DeviceDetailsInfo;
import com.boot.core.rabbitmq.model.DeviceInfo;
import com.boot.core.rabbitmq.produer.RabbitMQProducer;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootApplication(scanBasePackages = "com.boot.core.rabbitmq")
public class CoreRabbitMQApp implements CommandLineRunner {

	@Autowired
	private RabbitMQProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(CoreRabbitMQApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PodamFactory factory = new PodamFactoryImpl();
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			DeviceDetailsInfo deviceDetailsInfo = factory.manufacturePojo(DeviceDetailsInfo.class);
			DeviceInfo deviceInfo = factory.manufacturePojo(DeviceInfo.class);
			deviceInfo.setDeviceDetailsInfo(deviceDetailsInfo);
			producer.publish(deviceInfo);
		}
		System.exit(0);
	}
}
