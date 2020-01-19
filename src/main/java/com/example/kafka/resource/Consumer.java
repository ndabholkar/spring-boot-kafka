package com.example.kafka.resource;

import com.example.kafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = "Kafka_String", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}


	@KafkaListener(topics = "Kafka_JSON", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed JSON Message: " + user);
	}
}
