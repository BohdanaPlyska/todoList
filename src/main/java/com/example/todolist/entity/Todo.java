package com.example.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue
    private  Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
}
