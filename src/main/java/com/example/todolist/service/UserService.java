package com.example.todolist.service;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(UserDTO userDTO);

    void delete(Long userId);

    List<User> listAllUsers();

    Optional<User> getUser(Long id);

    User getById(Long id);
}
