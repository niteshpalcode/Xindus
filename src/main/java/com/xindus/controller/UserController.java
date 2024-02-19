package com.xindus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xindus.entity.User;
import com.xindus.service.UserDetailService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserDetailService userDetailService;
	

	@Autowired
	public UserController(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (userDetailService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        userDetailService.signUp(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userDetailService.login(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
