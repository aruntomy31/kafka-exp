package com.example.kafka.listener;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.kafka.model.Farewell;
import com.example.kafka.model.Greeting;

import lombok.extern.slf4j.Slf4j;

/**
 * @author arun
 */

@Slf4j
@Component
@KafkaListener(groupId = "${com.example.kafka.groupId}", topics = {"${com.example.kafka.topic1}","${com.example.kafka.topic2}", "${com.example.kafka.topic3}"})
public class MultiEventListener {

	@KafkaHandler
	public void handleGreetings(Greeting greeting) {
		log.info("Received greeting message: {}", greeting.toString());
	}

	@KafkaHandler
	public void handleFarewell(Farewell farewell) {
		log.info("Received farewell message: {}", farewell.toString());
	}

	@KafkaHandler(isDefault = true)
	public void unknown(Object object) {
		log.info("Unkown type received: ", object.toString());
	}
}
