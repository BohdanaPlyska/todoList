package com.example.todolist.mappers;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

     UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

     UserDTO userToUserDto(User user);

     User userDtoToUser(UserDTO userDTO);
}
