package com.example.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * @author arun
 * 
 */
@Configuration
public class KafkaTopicConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;

	@Value(value = "${com.example.kafka.topic1}")
	private String topicName1;

	@Value(value = "${com.example.kafka.topic2}")
	private String topicName2;

	@Value(value = "${com.example.kafka.topic3}")
	private String outputTopic;

	@Bean
	KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new KafkaAdmin(configs);
	}

	@Bean
	NewTopic topic1() {
		return new NewTopic(topicName1, 1, (short) 1);
	}

	@Bean
	NewTopic topic2() {
		return new NewTopic(topicName2, 1, (short) 1);
	}

	@Bean
	NewTopic topic3() {
		return new NewTopic(outputTopic, 1, (short) 1);
	}

}
