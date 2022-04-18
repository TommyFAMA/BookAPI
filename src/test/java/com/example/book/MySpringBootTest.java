package com.example.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MySpringBootTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnFirstBook() throws Exception {
		Book b= this.restTemplate.getForObject("http://localhost:" + port + "/books/1", Book.class);
		assertEquals("Hacking with Spring Boot 2.3", b.getTitle());
		assertEquals("Greg L. Turnquist", b.getAuthor());
	}
}