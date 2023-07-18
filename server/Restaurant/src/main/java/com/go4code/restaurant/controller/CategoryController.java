package com.go4code.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go4code.restaurant.dto.CategoryDTO;
import com.go4code.restaurant.mapper.CategoryMapper;
import com.go4code.restaurant.model.Category;
import com.go4code.restaurant.service.CategoryService;

@RestController
@RequestMapping(value = "/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<Category> categories = categoryService.findAll();
		List<CategoryDTO> retVal = this.categoryMapper.toDTOList(categories);
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	
}
