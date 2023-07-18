package com.go4code.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go4code.restaurant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsernameAndPassword(String username, String password);;

}
