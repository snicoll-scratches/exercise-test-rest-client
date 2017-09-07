package com.example.exercise.test.restclient;

import com.example.exercise.test.restclient.quote.QuoteClient;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleApplicationRunner implements ApplicationRunner {

	private final QuoteClient quoteClient;

	public SampleApplicationRunner(QuoteClient quoteClient) {
		this.quoteClient = quoteClient;
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("==================================");
		System.out.println(quoteClient.getRandomQuote());
		System.out.println("==================================");
	}
}
