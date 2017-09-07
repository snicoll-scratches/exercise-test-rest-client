package com.example.exercise.test.restclient.quote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

final class QuoteResponse {

	private final String type;
	private final Quote value;

	@JsonCreator
	public QuoteResponse(@JsonProperty("type") String type,
			@JsonProperty("value") Quote value) {
		this.type = type;
		this.value = value;
	}

	public String getType() {
		return this.type;
	}

	public Quote getValue() {
		return this.value;
	}

}
