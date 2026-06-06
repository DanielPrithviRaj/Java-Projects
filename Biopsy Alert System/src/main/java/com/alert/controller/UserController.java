package com.alert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alert.entity.User;
import com.alert.serviceInterface.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
		private final UserService userService;
		
		public UserController(UserService userService) {
			this.userService = userService;
		}
		
		@PostMapping("/save")
		public User createUser(@RequestBody User user) {
			return userService.createUser(user);
		}
		
		@GetMapping("/")
		public String home() {
		    return "Application is working";
		}
}
