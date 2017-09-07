package com.example.exercise.test.restclient.quote;

import java.net.URI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class QuoteClient {

	private final RestTemplate restTemplate;

	private final URI serviceURI;

	public QuoteClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		this.serviceURI = UriComponentsBuilder.fromUriString(
				"http://gturnquist-quoters.cfapps.io/api/random").build().toUri();
	}

	public Quote getRandomQuote() {
		RequestEntity<?> request = RequestEntity.get(serviceURI)
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<QuoteResponse> response = this.restTemplate.exchange(
				request, QuoteResponse.class);
		return response.getBody().getValue();
	}

}
