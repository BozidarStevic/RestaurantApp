package com.go4code.restaurant.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.go4code.restaurant.dto.ItemDTO;
import com.go4code.restaurant.model.Item;


@Component
@Mapper(componentModel = "spring")
public interface ItemMapper {
	
	public ItemDTO toDTO(Item item);
	public Item fromDTO(ItemDTO itemDTO);
	
	public List<ItemDTO> toDTOList(List<Item> itemCollection);
	public List<Item> fromDTOList(List<ItemDTO> itemDTOCollection);
	
}
