package com.scotia.todo.domain.repository;

import com.scotia.todo.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface taskRepository {
    List<Todo> getAll();

    Optional<List<Todo>> getByStatus(int statusId);

    Optional<List<Todo>> getTask(int taskId);

    Todo save(Todo todo);

    void delete(int taskId);


}
