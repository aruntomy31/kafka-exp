package com.example.kafka.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Farewell {

	private String message;
	private Integer remainingMinutes;
}
