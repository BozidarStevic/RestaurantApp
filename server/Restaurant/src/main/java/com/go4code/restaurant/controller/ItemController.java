package com.go4code.restaurant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.go4code.restaurant.dto.ItemDTO;
import com.go4code.restaurant.mapper.ItemMapper;
import com.go4code.restaurant.model.Item;
import com.go4code.restaurant.service.ItemService;


@RestController
@RequestMapping(value = "/api/items")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemMapper itemMapper;
	
	@GetMapping(value = "/count")
	public ResponseEntity<Long> countItems(@RequestParam(required = false) String name) {
		Long itemsCount;
		if (name != null) {
			itemsCount = itemService.countByName(name);
		}
		else {
			itemsCount = itemService.countItems();
		}
		
		return new ResponseEntity<>(itemsCount, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> getItems(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long categoryId,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
		
		Pageable paging = PageRequest.of(page, size);
		Page<Item> items;
		
		if (name != null && categoryId == null) {
			items = itemService.findByName(name, paging);
		}
		else {
			items = itemService.findAll(paging);
		}
		
		List<ItemDTO> retVal = this.itemMapper.toDTOList(items.getContent());
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDTO> create(@RequestBody Item item) {
		Item items = itemService.save(item);
		ItemDTO retVal = this.itemMapper.toDTO(items);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDTO> update(@PathVariable Long id,
			@RequestBody Item item) {
		if (itemService.findOne(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		item.setId(id);
		Item items = itemService.save(item);
		ItemDTO retVal = this.itemMapper.toDTO(items);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> delete(@PathVariable Long id) {
		Item item = itemService.findOne(id);
		if (item != null) {
			itemService.remove(id);
			return new ResponseEntity<>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
