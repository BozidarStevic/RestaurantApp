package com.go4code.restaurant.dto;

public class ItemDTO {
	
	private Long id;
	private String name;
	private CategoryDTO category;
	private double price;
	
	public ItemDTO() {
		super();
	}

	public ItemDTO(String name, CategoryDTO category, double price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public ItemDTO(Long id, String name, CategoryDTO category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
