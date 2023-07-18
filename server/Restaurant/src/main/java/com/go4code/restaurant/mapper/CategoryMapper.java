package com.go4code.restaurant.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.go4code.restaurant.dto.CategoryDTO;
import com.go4code.restaurant.model.Category;


@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	public CategoryDTO toDTO(Category category);
	public Category fromDTO(CategoryDTO categoryDTO);
	
	public List<CategoryDTO> toDTOList(List<Category> categoryCollection);
	public List<Category> fromDTOList(List<CategoryDTO> categoryDTOCollection);
	
}
