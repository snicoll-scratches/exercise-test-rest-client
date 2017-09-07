package com.example.exercise.test.restclient.quote;

import org.junit.Before;
import org.junit.Test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

public class QuoteClientTests {

	private MockRestServiceServer mockServer;

	private QuoteClient quoteClient;

	@Before
	public void setUp() {
		RestTemplate restTemplate = new RestTemplate();
		this.mockServer = MockRestServiceServer.createServer(restTemplate);
		this.quoteClient = new QuoteClient( restTemplate);
	}

	@Test
	public void getRandomQuote() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		this.mockServer.expect(requestTo("http://gturnquist-quoters.cfapps.io/api/random"))
				.andExpect(method(HttpMethod.GET))
				.andExpect(header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE))
				.andRespond(withStatus(HttpStatus.OK)
						.body(new ClassPathResource("quote/quote-10.json"))
						.headers(httpHeaders));
		Quote randomQuote = quoteClient.getRandomQuote();
		assertThat(randomQuote).isNotNull();
		assertThat(randomQuote.getId()).isEqualTo(10);
		assertThat(randomQuote.getMessage()).isEqualTo(
				"Really loving Spring Boot, makes stand alone Spring apps easy.");
	}

}