package com.example.todolist.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Size(min=2, message = "Not less than 5 character")
   private String username;

   @Size(min=2, message = "Not less than 5 character")
   private String password;

   @Size(min=2, message = "Nit less than 5 character")
   private String name;

   @Size(min=2, message = "Not less than 5 character")
   private String lastName;

   @Email
   private String email;

   @Transient
   private String passwordConfirm;
}
