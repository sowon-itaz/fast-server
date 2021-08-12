package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/user/{userId}/name/{userName}")
	public User post(@RequestBody User user, @PathVariable String userId, @PathVariable String userName) {
		log.info("client req: {}", user);
		log.info("userId: {}, userName: {}", userId, userName);
		return user;
	}
}
