package com.go4code.restaurant.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go4code.restaurant.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	public Page<Item> findByNameContaining(String name, Pageable paging);
	
	public List<Item> findByNameContaining(String name);

	public Page<Item> findByCategoryId(Long categoryId, Pageable paging);

	public Page<Item> findByNameContainingAndCategoryId(String name, Long categoryId, Pageable paging);
	
	public Long countByName(String name);
	
}