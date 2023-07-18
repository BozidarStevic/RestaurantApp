package com.go4code.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.go4code.restaurant.dto.UserDTO;
import com.go4code.restaurant.mapper.UserMapper;
import com.go4code.restaurant.model.User;
import com.go4code.restaurant.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping
	public ResponseEntity<UserDTO> getUser(@RequestParam String username,
			@RequestParam String password) {
		
		User user = userService.findUser(username, password);
		
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		UserDTO retVal = this.userMapper.toDTO(user);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
