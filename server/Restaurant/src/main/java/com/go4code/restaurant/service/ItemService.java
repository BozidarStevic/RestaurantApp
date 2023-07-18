package com.go4code.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.go4code.restaurant.model.Item;
import com.go4code.restaurant.repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public Page<Item> findAll(Pageable paging) {
		return itemRepository.findAll(paging);
	}

	public Page<Item> findByName(String name, Pageable paging) {
		return itemRepository.findByNameContaining(name, paging);
	}

	public Page<Item> findByCategory(Long categoryId, Pageable paging) {
		return itemRepository.findByCategoryId(categoryId, paging);
	}

	public Page<Item> findByNameAndCategory(String name, Long categoryId, Pageable paging) {
		return itemRepository.findByNameContainingAndCategoryId(name, categoryId, paging);
	}

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public Item findOne(Long id) {
		Optional<Item> optItem = itemRepository.findById(id);
		Item item = null;
		if (optItem.isPresent()) {
			item = optItem.get();
		}
		return item;
	}

	public void remove(Long id) {
		itemRepository.deleteById(id);
	}
	
	public Long countByName(String name) {
		List<Item> items = itemRepository.findByNameContaining(name);
		return (long) items.size();
	}

	public Long countItems() {
		return itemRepository.count();
	}
}
