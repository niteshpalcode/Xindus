package com.xindus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xindus.entity.User;
import com.xindus.repository.UserRepository;
import com.xindus.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	 private final UserService userService;

	    @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
	 @Autowired
	 private UserRepository userRepository;

	 @PostMapping("/signup")
	    public ResponseEntity<String> signUp(@RequestBody User user) {
	        if (userRepository.existsByUsername(user.getUsername())) { 
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
	        }

	        userService.signUp(user);
	        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
	    }

	    @GetMapping("/login")
	    public ResponseEntity<String> login() {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please login");
	    }
}
