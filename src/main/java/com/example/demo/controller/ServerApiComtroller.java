package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

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
}
