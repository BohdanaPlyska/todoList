package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static com.example.todolist.constants.DefaultAppConstants.TODO_SAVE_TODO_PAGE_URL;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping(TODO_SAVE_TODO_PAGE_URL)
    public ResponseEntity<Todo> saveAndUpdate(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.saveAndUpdate(todo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = new ArrayList<>();
        todoService.findAll().forEach(todos::add);
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        todoService.delete(id);
        if(todoService.getTodo(id).isPresent()) {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }



}
