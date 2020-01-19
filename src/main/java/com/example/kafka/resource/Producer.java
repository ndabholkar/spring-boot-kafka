package com.example.kafka.resource;

import com.example.kafka.model.User;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class Producer {

	private final KafkaTemplate<String, User> kafkaTemplate;

	@Autowired
	public Producer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	private static final String TOPIC_STRING= "Kafka_String";
	private static final String TOPIC_JSON = "Kafka_JSON";

	@GetMapping("/{name}")
	public User post(@PathVariable("name") final String name) {
		Random random = new Random(System.nanoTime());
		User user = new User(name, UUID.randomUUID().toString(), random.nextInt(50));
//		Message<User> message = MessageBuilder.withPayload(user)
//												.setHeader(KafkaHeaders.TOPIC, TOPIC)
//												.build();
//		ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(message);
		ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(TOPIC_JSON, user);
		future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {

			@Override
			public void onSuccess(SendResult<String, User> result) {
				System.out.println("Sent message=[" + user + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			}
			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Unable to send message=[" + user + "] due to : " + ex.getMessage());
			}
		});

		return user;
	}
}
