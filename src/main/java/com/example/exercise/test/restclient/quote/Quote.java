package com.example.exercise.test.restclient.quote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Quote {

	private final int id;

	private final String message;

	@JsonCreator
	public Quote(@JsonProperty("id") int id, @JsonProperty("quote") String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return this.id;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "Quote{" + "id=" + id + ", message='" + message + "'}";
	}
}

