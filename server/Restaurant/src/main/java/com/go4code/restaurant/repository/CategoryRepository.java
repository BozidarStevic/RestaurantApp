package com.go4code.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go4code.restaurant.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
