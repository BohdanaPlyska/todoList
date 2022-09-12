package com.example.todolist.mappers;
import com.example.todolist.dto.TodoDTO;
import com.example.todolist.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapper {

    TodoMapper INSTANCE= Mappers.getMapper(TodoMapper.class);

    TodoDTO todoToTodoDto(Todo todo);

    Todo todoDtoToTodo(TodoDTO todoDTO);

}
