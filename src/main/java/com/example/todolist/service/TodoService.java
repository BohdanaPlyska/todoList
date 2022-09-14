package com.example.todolist.service;

import com.example.todolist.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Todo saveAndUpdate(Todo todoDTO);

    void delete(Long id);

    List<Todo> findAll();

    Optional<Todo> getTodo(Long id);

    Todo findById(Long id);

}
