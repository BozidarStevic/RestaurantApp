package com.go4code.restaurant.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.go4code.restaurant.dto.UserDTO;
import com.go4code.restaurant.model.User;


@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
	
	public UserDTO toDTO(User user);
	public User fromDTO(UserDTO userDTO);
	
	public List<UserDTO> toDTOList(List<User> userCollection);
	public List<User> fromDTOList(List<UserDTO> userDTOCollection);
	
}
