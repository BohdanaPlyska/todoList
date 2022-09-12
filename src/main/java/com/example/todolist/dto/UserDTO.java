package com.example.todolist.dto;

import com.example.todolist.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
