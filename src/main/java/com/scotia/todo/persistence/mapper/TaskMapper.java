package com.scotia.todo.persistence.mapper;

import com.scotia.todo.domain.Todo;
import com.scotia.todo.persistence.TaskRepository;
import com.scotia.todo.persistence.entity.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StatusMapper.class} )
public interface TaskMapper {
    @Mappings({
        @Mapping(source = "idTask", target = "taskId"),
        @Mapping(source = "title", target = "taskTitle"),
        @Mapping(source = "description", target = "taskDescription"),
        @Mapping(source = "idStatus", target = "statusId"),
        @Mapping(source = "createdAt", target = "createdDate"),
        @Mapping(source = "completedAt", target = "completedDate"),
        @Mapping(source = "status", target = "taskState"),
    })
    Task toTask(Todo todo);
    List<Task> toTask(List<Todo> todos);

    @InheritInverseConfiguration
    Todo toTodo(Task task);

}
