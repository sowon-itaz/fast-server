package com.example.demo.controller;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerNaverApiComtroller {

	@GetMapping("/naver")
	public String naver() {
		
		// https://openapi.naver.com/v1/search/local.json
		// ?query=%EA%B0%88%EB%B9%84%EC%A7%91
		// &display=10
		// &start=1
		// &sort=random
		
		String searchword = "치킨";
		
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/search/local.json")
				.queryParam("query", searchword)
				.queryParam("display", 10)
				.queryParam("start", 1)
				.queryParam("sort", "random")
				.encode()
				.build()
				.toUri();
		
		log.info("uri: {}", uri);
		
		RestTemplate rt = new RestTemplate();
		RequestEntity<Void> req = RequestEntity
								  .get(uri)
								  .header("X-Naver-Client-Id", "ENfdHthBz2AlqNCW3ggg")
								  .header("X-Naver-Client-Secret", "azSIZbI89d")
								  .build();
		
		ResponseEntity<String> result = rt.exchange(req, String.class);
		
		return result.getBody();
	}
	
}
