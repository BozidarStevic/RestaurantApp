package com.go4code.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go4code.restaurant.model.Category;
import com.go4code.restaurant.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoriRepository;

	public List<Category> findAll() {
		return categoriRepository.findAll();
	}

}
