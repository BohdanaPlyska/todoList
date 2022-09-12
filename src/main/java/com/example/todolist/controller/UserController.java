package com.example.todolist.controller;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.todolist.constants.DefaultAppConstants.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping (USER_SAVE_USER_PAGE_URL)
    public ResponseEntity<User> saveAndUpdate(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.saveAndUpdate(user), HttpStatus.CREATED);
    }

    @DeleteMapping(USER_DELETE_PAGE_URL)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        userService.delete(id);
        if (userService.getUser(id).isPresent()) {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    @GetMapping(USERS_PAGE_URL)
    public ResponseEntity<List<User>> getAll() {
        List<User> users = new ArrayList<>();
        userService.listAllUsers().forEach(users::add);
        return ResponseEntity.ok(users);
    }
}
