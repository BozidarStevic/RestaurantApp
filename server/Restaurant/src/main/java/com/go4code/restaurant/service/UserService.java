package com.go4code.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go4code.restaurant.model.User;
import com.go4code.restaurant.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
}
