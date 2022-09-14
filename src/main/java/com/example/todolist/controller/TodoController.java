package com.example.todolist.controller;

import com.example.todolist.dto.TodoDTO;
import com.example.todolist.entity.Todo;
import com.example.todolist.mappers.TodoMapper;
import com.example.todolist.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static com.example.todolist.constants.DefaultAppConstants.*;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);


    @PostMapping(TODO_SAVE_TODO_PAGE_URL)
    public ResponseEntity<Todo> saveAndUpdate(@RequestBody TodoDTO todo) {
        return new ResponseEntity<>(todoService.saveAndUpdate(TodoMapper.INSTANCE.todoDtoToTodo(todo)), HttpStatus.CREATED);
    }

    @GetMapping(TODO_FIND_ALL_PAGE_URL)
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = new ArrayList<>();
        todos.addAll(todoService.findAll());
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping(TODO_DELETE_TODO_PAGE_URL)
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        todoService.delete(id);
        if(todoService.getTodo(id).isPresent()) {
            LOGGER.error("An error occurs during deleting the user");
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        } else {
            LOGGER.info("The user was deleted");
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    @GetMapping(TODO_GET_TODO_PAGE_URL)
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        return ResponseEntity.accepted().body(todoService.findById(id));
    }

}
