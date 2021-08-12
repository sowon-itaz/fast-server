package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Req;
import com.example.demo.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiComtroller {

	@GetMapping("")
	public User hello(@RequestParam String name, @RequestParam int age) {
		User u = new User();
		u.setName(name);
		u.setAge(age);
		return u;
	}
	
//	@PostMapping("/user/{userId}/name/{userName}")
	public User post(@RequestBody User user, @PathVariable String userId, @PathVariable String userName) {
		log.info("client req: {}", user);
		log.info("userId: {}, userName: {}", userId, userName);
		return user;
	}
	
//	@PostMapping("/user/{userId}/name/{userName}")
	public User exchange(@RequestBody User user, 
						 @PathVariable String userId,
						 @PathVariable String userName,
						 @RequestHeader("x-authorization") String xAuthorization,
						 @RequestHeader("custom-header") String customHeader
						 ) {
		log.info("client req: {}", user);
		log.info("userId: {}, userName: {}", userId, userName);
		log.info("xAuthorization: {}, customHeader: {}", xAuthorization, customHeader);
		return user;
	}

	// 순수한 HttpEntity<String>을 파라미터 변수로 받으면 디버깅 등에 유용하다
	@PostMapping("/user/{userId}/name/{userName}")
	public Req<User> genericExchange(
//							HttpEntity<String> entity, 
							@RequestBody Req<User> user, 
							@PathVariable String userId,
							@PathVariable String userName,
							@RequestHeader("x-authorization") String xAuthorization,
							@RequestHeader("custom-header") String customHeader
		) {
//		log.info("entity 순수한 : {}", entity);
		log.info("client HttpEntity<String>을 파라미터 변수로 받으면 디버깅 등에 유용: {}", user);
		log.info("userId: {}, userName: {}", userId, userName);
		log.info("xAuthorization: {}, customHeader: {}", xAuthorization, customHeader);
		
		// 원하는 json형태로 응답하기
		/*{
		    "header": {
		        "resCode": null
		    },
		    "responseBody": {
		        "name": "가나다",
		        "age": 55
		    }
		}*/
		Req<User> response = new Req<>();
		response.setHeader(new Req.Header());
		response.setResponseBody(user.getResponseBody());
		
		return response;
	}
}
