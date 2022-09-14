package com.example.todolist.service.impl;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.mappers.UserMapper;
import com.example.todolist.repository.UserRepository;
import com.example.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.todolist.entity.Role.ROLE_USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(UserDTO userDTO) {
        if(userDTO.getPassword() != null) {
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        }
        userDTO.setRole(ROLE_USER);
        return userRepository.save(UserMapper.INSTANCE.userDtoToUser(userDTO));
    }

    @Override
    public void delete(Long userId) {
       Optional<User> userOptional = userRepository.findById(userId);
       userOptional.ifPresent(userRepository::delete);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }
}
