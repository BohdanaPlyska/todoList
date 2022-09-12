package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TodoDTO {
    private  Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
}
