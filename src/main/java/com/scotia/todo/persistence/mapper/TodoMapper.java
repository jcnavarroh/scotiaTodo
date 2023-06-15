package com.scotia.todo.persistence.mapper;

import com.scotia.todo.domain.Todo;
import com.scotia.todo.persistence.entity.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StateMapper.class} )
public interface TodoMapper {
    @Mappings({
        @Mapping(source = "idTask", target = "todoId"),
        @Mapping(source = "title", target = "todoTitle"),
        @Mapping(source = "description", target = "todoDescription"),
        @Mapping(source = "idStatus", target = "statusId"),
        @Mapping(source = "createdAt", target = "createdDate"),
        @Mapping(source = "completedAt", target = "completedDate"),
        @Mapping(source = "status", target = "todoState"),
    })
    Todo toTodo(Task task);
    List<Todo> toTodos(List<Task> tasks);

    @InheritInverseConfiguration
    Task toTask(Todo todo);

}
