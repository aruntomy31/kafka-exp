package com.example.kafka.api;

import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.model.Farewell;
import com.example.kafka.model.Greeting;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MessageController {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping("/sendGreeting")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void sendMessage(@RequestBody Greeting greeting) {
		kafkaTemplate.send("baeldung0", greeting);
		log.info("Message published successfully.");
	}
	
	@PostMapping("/sendFarewell")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void sendFarewellMessage(@RequestBody Farewell farewell) {
		kafkaTemplate.send("baeldung1", farewell);
		log.info("Message published successfully.");
	}

}
