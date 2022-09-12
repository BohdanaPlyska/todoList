package com.example.todolist.service.impl;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl (TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo saveAndUpdate(Todo todoDTO) {
        return todoRepository.save(todoDTO);
    }

    @Override
    public void delete(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        optionalTodo.ifPresent(todoRepository::delete);
    }

    @Override
    public List<Todo> findAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }
}
