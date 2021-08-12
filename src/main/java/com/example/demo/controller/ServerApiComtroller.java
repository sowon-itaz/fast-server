package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
@RequestMapping("/api/server")
public class ServerApiComtroller {

	@GetMapping("")
	public User hello() {
		User u = new User();
		u.setName("차지연");
		u.setAge(33);
		return u;
	}
}
